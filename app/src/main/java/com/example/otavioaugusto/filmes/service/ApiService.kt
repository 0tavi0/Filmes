package com.example.otavioaugusto.filmes.service

import com.example.otavioaugusto.filmes.model.Filme
import retrofit2.http.GET
import retrofit2.Call


interface ApiService {

    @GET("Movies")
    fun getFilmes(): Call<List<Filme>>


}