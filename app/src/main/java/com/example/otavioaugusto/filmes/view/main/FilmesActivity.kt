package com.example.otavioaugusto.filmes.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast

import com.example.otavioaugusto.filmes.R
import com.example.otavioaugusto.filmes.model.Filme
import com.example.otavioaugusto.filmes.presenter.FilmesPresenter
import com.example.otavioaugusto.filmes.utils.CheckConnection
import com.example.otavioaugusto.filmes.view.main.adapter.FilmesAdapter
import kotlinx.android.synthetic.main.activity_filmes.*

class FilmesActivity : AppCompatActivity(), FilmesContrato.View {


    lateinit var presenter: FilmesContrato.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmes)


        if (!CheckConnection.isNetworkConnected(this)){
            CheckConnection.alerta(getString(R.string.opsConnection),getString(R.string.mesageConnection), this)
        }

        presenter = FilmesPresenter(this)
        presenter.getDadosAPI()

        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.setHasFixedSize(true)

    }


    override fun ListaFilmes(lista: List<Filme>) {
        val adapter = FilmesAdapter(lista, this)
        recycler.adapter = adapter
    }

    override fun mensagemErro(msg:String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE

    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE

    }


}
