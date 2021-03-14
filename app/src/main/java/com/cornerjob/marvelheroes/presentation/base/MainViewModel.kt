package com.cornerjob.marvelheroes.presentation.base

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.cornerjob.marvelheroes.domain.repository.MarvelMainRepository
import com.cornerjob.marvelheroes.presentation.util.NetworkHelper
import com.cornerjob.marvelheroes.presentation.util.Resource
import kotlinx.coroutines.launch
import com.cornerjob.marvelheroes.domain.model.Result


class MainViewModel @ViewModelInject constructor(
        private val mainRepository: MarvelMainRepository,
        private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _data = MutableLiveData<Resource<List<Result>>>()
    val users: LiveData<Resource<List<Result>>>
        get() = _data

    init {
        fetchHeroes()
    }

    private fun fetchHeroes() {
        viewModelScope.launch {
            _data.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _data.postValue(Resource.success(it.body()?.data?.results))
                        Log.d("dataList", ": " + Resource.success(it.body()).toString())
                    } else _data.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _data.postValue(Resource.error("No internet connection", null))
        }
    }
}