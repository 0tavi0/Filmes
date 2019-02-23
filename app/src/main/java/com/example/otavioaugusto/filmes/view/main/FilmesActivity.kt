package com.example.otavioaugusto.filmes.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager

import com.example.otavioaugusto.filmes.R
import com.example.otavioaugusto.filmes.model.Filme
import com.example.otavioaugusto.filmes.presenter.FilmesPresenter
import com.example.otavioaugusto.filmes.view.main.adapter.FilmesAdapter
import kotlinx.android.synthetic.main.activity_filmes.*

class FilmesActivity : AppCompatActivity(), FilmesContrato.View {


    lateinit var presenter: FilmesContrato.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmes)

        presenter = FilmesPresenter(this)

        presenter.getDadosAPI()


        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.setHasFixedSize(true)

    }

    override fun ListaFilmes(lista: List<Filme>) {
        val adapter = FilmesAdapter(lista, this)
        recycler.adapter = adapter




    }
}
