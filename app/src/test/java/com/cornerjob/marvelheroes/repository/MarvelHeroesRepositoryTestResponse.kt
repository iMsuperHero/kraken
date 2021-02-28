package com.cornerjob.marvelheroes.repository

import com.cornerjob.marvelheroes.data.model.MarvelHeroResponse
import com.cornerjob.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.cornerjob.marvelheroes.domain.repository.MarvelHeroesRepositoryImpl
import com.cornerjob.marvelheroes.domain.repository.datasource.RemoteMarvelHeroesDataSource
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

class MarvelHeroesRepositoryTestResponse {

    private val mockRemoteDataSource: RemoteMarvelHeroesDataSource = mock()

    private lateinit var mapper: MarvelHeroMapper
    private lateinit var marvelHeroesRepository: MarvelHeroesRepositoryImpl

    @Before
    fun setUp() {
        mapper = MarvelHeroMapper()
        marvelHeroesRepository = MarvelHeroesRepositoryImpl(mockRemoteDataSource, mapper)
    }

    @Test
    fun `repository should retrieve marvel heroes list`() {
        val heroes = listOf(MarvelHeroResponse("Iron Man"), MarvelHeroResponse("Spider-Man"))
        val observable = Observable.just(heroes)
        whenever(mockRemoteDataSource.getMarvelHeroesList()).thenReturn(observable)

        val result = marvelHeroesRepository.getMarvelHeroesList()

        verify(mockRemoteDataSource).getMarvelHeroesList()
        result.test()
                .assertValue { it.size == 2 }
                .assertValue { it.first().name == heroes.first().name }
                .assertValue { it.last().name == heroes.last().name }
    }

}