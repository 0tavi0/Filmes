package com.example.otavioaugusto.filmes.view.details

import android.os.Bundle
import android.support.design.R.attr.layoutManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.otavioaugusto.filmes.R
import com.example.otavioaugusto.filmes.model.Filme
import com.example.otavioaugusto.filmes.view.details.adapter.DetailsAdapter
import com.example.otavioaugusto.filmes.view.main.adapter.FilmesAdapter
import kotlinx.android.synthetic.main.activity_detail_filme.*
import kotlinx.android.synthetic.main.activity_filmes.*
import kotlinx.android.synthetic.main.content_detail_filme.*

class DetailFilme : AppCompatActivity() {

    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_filme)
        setSupportActionBar(toolbar)


        val i = intent
        var obj = i.getSerializableExtra("obj") as Filme

        txtDetailsOverview.text = obj.overview
        setTitle(obj.title)


//        recyclerDetails.layoutManager = GridLayoutManager(this, 2)

        layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerDetails.layoutManager = layoutManager

        recyclerDetails.setHasFixedSize(true)
        recyclerDetails.addItemDecoration(DividerItemDecoration(this, (recyclerDetails.layoutManager as LinearLayoutManager).orientation))

        val adapter = DetailsAdapter(obj.backdrops_url, this)
        recyclerDetails.adapter = adapter
    }
}
