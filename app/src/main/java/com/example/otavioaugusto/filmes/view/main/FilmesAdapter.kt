package com.example.otavioaugusto.filmes.view.main

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.otavioaugusto.filmes.R
import com.example.otavioaugusto.filmes.model.Filme
import com.squareup.picasso.Picasso

class FilmesAdapter(val lista:List<Filme>, val context: Context):RecyclerView.Adapter<FilmesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
        val ivh = ViewHolder(v)
        return ivh
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle.text = lista[position].title

        Picasso.get().load(lista[position].cover_url).into(holder.imgCover)
//
//        val imageUri = Uri.parse(lista[position].cover_url)
//        holder.imgCover.setImageURI(imageUri)

    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById(R.id.txtTitulo) as TextView
        val imgCover = itemView.findViewById(R.id.imgCover) as ImageView

    }

    }




