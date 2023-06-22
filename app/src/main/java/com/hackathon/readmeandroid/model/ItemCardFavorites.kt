package com.hackathon.readmeandroid.model

import androidx.annotation.DrawableRes

data class ItemCardFavorites(
    @DrawableRes var image: Int,
    var enterprisename : String,
    var enterpriselocation: String
)