package com.cornerjob.marvelheroes.presenter

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class HeroesListPresenterTest {

    private val view: HeroesListContract.View = mock()
    private val useCase: GetMarvelHeroesList = mock()

    lateinit var presenter: HeroesListPresenter

    @Before
    fun setUp() {
        presenter = HeroesListPresenter(view, useCase)
    }

    @Test
    fun `test presenter initialization`() {
        presenter.loadMarvelHeroes()

        verify(view).showLoading(true)
        verify(useCase).execute(any(), any())
    }

}