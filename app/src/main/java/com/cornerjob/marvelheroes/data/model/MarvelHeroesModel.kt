package com.cornerjob.marvelheroes.data.model

import com.google.gson.annotations.SerializedName

data class MarvelDataResponse(
        @SerializedName("data")
        val heroesData: MarvelHeroesResponse
)

data class MarvelHeroesResponse(
        @SerializedName("results")
        val superheroes: List<MarvelHeroResponse>
)

data class MarvelHeroResponse(
        val name: String = "",
        val thumbnail: MarvelHeroThumbnail = MarvelHeroThumbnail(),
        val description: String = ""
)

data class MarvelHeroThumbnail(
        val path: String = "",
        val extension: String = ""
) {
        val url = "$path.$extension"
}
