package com.cornerjob.marvelheroes.data.net


import com.cornerjob.marvelheroes.domain.model.Heroes
import retrofit2.Response

interface MarvelHeroesHelper {
    suspend fun getUsers(): Response<Heroes>
}