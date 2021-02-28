package com.cornerjob.marvelheroes.domain.repository

import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

interface MarvelHeroesRepository {

    fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>>

}