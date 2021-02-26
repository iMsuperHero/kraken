package com.cornerjob.marvelheroes.data.repository

import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

interface MarvelHeroesRepository {

    fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>>

}