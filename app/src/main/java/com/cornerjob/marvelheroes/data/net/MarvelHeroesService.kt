package com.cornerjob.marvelheroes.data.net

import com.cornerjob.marvelheroes.domain.model.Heroes
import retrofit2.Response
import retrofit2.http.GET

interface MarvelHeroesService {
    @GET("characters")
    suspend fun getHeroes(): Response<Heroes>
}