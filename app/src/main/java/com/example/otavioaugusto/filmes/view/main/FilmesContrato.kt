package com.example.otavioaugusto.filmes.view.main

import com.example.otavioaugusto.filmes.model.Filme

interface FilmesContrato {

    interface View{

        fun ListaFilmes(lista:List<Filme>)
    }

    interface Presenter{
        fun getDadosAPI()

    }
}