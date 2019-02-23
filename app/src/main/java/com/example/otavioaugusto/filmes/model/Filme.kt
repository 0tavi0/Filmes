package com.example.otavioaugusto.filmes.model

import com.google.gson.annotations.SerializedName

data class Filme (
    @SerializedName("title")
    var title: String,
    @SerializedName("overview")
    var overview:String,
    @SerializedName("duration")
    var duration:String,
    @SerializedName("release_year")
    var release_year:String,
    @SerializedName("cover_url")
    var cover_url:String,
    @SerializedName("backdrops_url")
    var backdrops_url: List<String>,
    @SerializedName("id")
    var id:String
)