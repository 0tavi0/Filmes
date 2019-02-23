package com.example.otavioaugusto.filmes.presenter

import android.util.Log
import com.example.otavioaugusto.filmes.model.Filme
import com.example.otavioaugusto.filmes.service.ApiService
import com.example.otavioaugusto.filmes.service.RetrofitService
import com.example.otavioaugusto.filmes.view.main.FilmesActivity
import com.example.otavioaugusto.filmes.view.main.FilmesContrato
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmesPresenter(var view: FilmesActivity):FilmesContrato.Presenter {

    override fun getDadosAPI() {
        var call = RetrofitService
            .retrofit.create(ApiService::class.java)
            .getFilmes()

        call.enqueue(object : Callback<List<Filme>>{
            override fun onFailure(call: Call<List<Filme>>, t: Throwable) {
                Log.e("failure", ""+t.message)

            }

            override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                Log.e("Aqui", ""+response.code())
               // Log.e("Aquiss", ""+response.body())

                var listOfMovies: List<Filme>? = response.body()


                if (response.isSuccessful){
                    view.ListaFilmes(listOfMovies!!)
                }

            }

        })
    }
}