package com.cornerjob.marvelheroes.domain.repository

import com.cornerjob.marvelheroes.data.net.MarvelHeroesHelper
import javax.inject.Inject

class MarvelMainRepository @Inject constructor(private val apiHelper: MarvelHeroesHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}