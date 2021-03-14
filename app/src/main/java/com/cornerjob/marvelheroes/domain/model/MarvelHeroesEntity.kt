package com.cornerjob.marvelheroes.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Heroes(
        @SerializedName("attributionHTML")
        val attributionHTML: String,
        @SerializedName("attributionText")
        val attributionText: String,
        @SerializedName("code")
        val code: Int,
        @SerializedName("copyright")
        val copyright: String,
        @SerializedName("data")
        val `data`: Data,
        @SerializedName("etag")
        val etag: String,
        @SerializedName("status")
        val status: String
)

data class Data(

        val count: Int,
        val limit: Int,
        val offset: Int,
        val results: List<Result>,
        val total: Int
)

@Parcelize
data class Result(
        val comics: Comics,
        val description: String,
        val events: Events,
        val id: Int,
        val modified: String,
        val name: String,
        val resourceURI: String,
        val series: Series,
        val stories: Stories,
        val thumbnail: Thumbnail,
        val urls: List<Url>
) : Parcelable

@Parcelize
data class Comics(
        val available: Int,
        val collectionURI: String,
        val items: List<Item>,
        val returned: Int
) : Parcelable

@Parcelize
data class Events(
        val available: Int,
        val collectionURI: String,
        val items: List<ItemX>,
        val returned: Int
) : Parcelable

@Parcelize
data class Series(
        val available: Int,
        val collectionURI: String,
        val items: List<ItemXX>,
        val returned: Int
) : Parcelable

@Parcelize
data class Stories(
        val available: Int,
        val collectionURI: String,
        val items: List<ItemXXX>,
        val returned: Int
) : Parcelable

@Parcelize
data class Thumbnail(
        val extension: String,
        val path: String
) : Parcelable

@Parcelize
data class Url(
        val type: String,
        val url: String
) : Parcelable

@Parcelize
data class Item(
        val name: String,
        val resourceURI: String
) : Parcelable

@Parcelize
data class ItemX(
        val name: String,
        val resourceURI: String
) : Parcelable

@Parcelize
data class ItemXX(
        val name: String,
        val resourceURI: String
) : Parcelable

@Parcelize
data class ItemXXX(
        val name: String,
        val resourceURI: String,
        val type: String
) : Parcelable