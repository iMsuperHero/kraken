package com.cornerjob.marvelheroes.data.model.mapper

import com.cornerjob.marvelheroes.data.model.MarvelHeroResponse
import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity

class MarvelHeroMapper : Mapper<MarvelHeroResponse, MarvelHeroEntity> {

    override fun transform(input: MarvelHeroResponse): MarvelHeroEntity =
            MarvelHeroEntity(
                    name = input.name,
                    photoUrl = input.thumbnail.path + "." + input.thumbnail.extension,
                    description = input.description
            )

    override fun transformList(inputList: List<MarvelHeroResponse>): List<MarvelHeroEntity> =
            inputList.map { transform(it) }

}