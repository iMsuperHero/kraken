package com.cornerjob.marvelheroes.domain.repository

import com.cornerjob.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.cornerjob.marvelheroes.domain.repository.datasource.RemoteMarvelHeroesDataSource
import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

class MarvelHeroesRepositoryImpl(private val remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource,
                                 private val marvelHeroesMapper: MarvelHeroMapper)
    : MarvelHeroesRepository {

    override fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>> =
        remoteMarvelHeroesDataSource
                .getMarvelHeroesList()
                .map { marvelHeroesMapper.transformList(it) }

}