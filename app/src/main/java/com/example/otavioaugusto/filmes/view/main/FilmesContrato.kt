package com.example.otavioaugusto.filmes.view.main

import com.example.otavioaugusto.filmes.model.Filme

interface FilmesContrato {

    interface View{

        fun ListaFilmes(lista:List<Filme>)
        fun mensagemErro(msg:String)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface Presenter{
        fun getDadosAPI()

    }
}