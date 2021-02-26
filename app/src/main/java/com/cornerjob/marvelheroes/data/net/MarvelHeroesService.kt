package com.cornerjob.marvelheroes.data.net

import com.cornerjob.marvelheroes.data.model.MarvelDataResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MarvelHeroesService {

    @GET("characters")
    fun getMarvelHeroesList(): Observable<MarvelDataResponse>

}