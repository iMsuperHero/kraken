package com.cornerjob.marvelheroes.presentation

import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity

object FakeData {
    const val NAME = "Iron Man"
    const val DESCRIPTION = "Anthony Edward \"Tony\" Stark"
    val IRON_MAN = MarvelHeroEntity(name = NAME, photoUrl = "", description = DESCRIPTION)
}