package com.cornerjob.marvelheroes.mapper

import com.cornerjob.marvelheroes.data.model.MarvelHeroResponse
import com.cornerjob.marvelheroes.data.model.MarvelHeroThumbnail
import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test

class MarvelHeroResponseMapperTest {

    private lateinit var marvelHeroMapper: MarvelHeroMapper

    @Before
    fun setUp() {
        marvelHeroMapper = MarvelHeroMapper()
    }

    @Test
    fun `Transform MarvelHero into MarvelHeroEntity`() {
        val marvelHero = MarvelHeroResponse("Iron Man", MarvelHeroThumbnail("ironman", "png"))

        val marvelHeroEntity = marvelHeroMapper.transform(marvelHero)

        Assertions.assertThat(marvelHeroEntity.name).isEqualTo(marvelHero.name)
        Assertions.assertThat(marvelHeroEntity.photoUrl).isEqualTo(marvelHero.thumbnail)
    }

    @Test
    fun `Transform MarvelHero collection into MarvelHeroEntity collection`() {
        val marvelHeroes = listOf(
                MarvelHeroResponse("Iron Man", MarvelHeroThumbnail("ironman", "png")),
                MarvelHeroResponse("Spider-Man", MarvelHeroThumbnail("spiderman", "png"))
        )

        val marvelHeroesEntities = marvelHeroMapper.transformList(marvelHeroes)

        Assertions.assertThat(marvelHeroes.size).isEqualTo(marvelHeroesEntities.size)
        Assertions.assertThat(marvelHeroesEntities).allMatch { it is MarvelHeroEntity }
        Assertions.assertThat(marvelHeroesEntities.first().name).isEqualTo(marvelHeroes.first().name)
        Assertions.assertThat(marvelHeroesEntities.last().name).isEqualTo(marvelHeroes.last().name)
    }

}