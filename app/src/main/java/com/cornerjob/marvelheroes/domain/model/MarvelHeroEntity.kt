package com.cornerjob.marvelheroes.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelHeroEntity(
        val name: String,
        val photoUrl: String,
        val description: String
) : Parcelable