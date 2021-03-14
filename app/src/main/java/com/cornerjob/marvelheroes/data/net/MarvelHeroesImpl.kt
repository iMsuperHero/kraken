package com.cornerjob.marvelheroes.data.net


import com.cornerjob.marvelheroes.domain.model.Heroes
import retrofit2.Response
import javax.inject.Inject

class MarvelHeroesImpl @Inject constructor(private val apiService: MarvelHeroesService) : MarvelHeroesHelper {
    override suspend fun getUsers(): Response<Heroes> = apiService.getHeroes()
}