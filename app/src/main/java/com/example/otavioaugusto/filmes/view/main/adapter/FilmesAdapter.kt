package com.example.otavioaugusto.filmes.view.main.adapter

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.otavioaugusto.filmes.R
import com.example.otavioaugusto.filmes.model.Filme
import com.example.otavioaugusto.filmes.view.details.DetailFilme
import com.squareup.picasso.Picasso
import java.io.Serializable
import java.util.*

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

        val filme = lista[position]

        holder.txtTitle.text = lista[position].title
        Picasso.get()
            .load(lista[position].cover_url)
            .placeholder(R.mipmap.ic_placeholder)
            .into(holder.imgCover)

        holder.txtYear.text = lista[position].release_year
        holder.txtDuration.text = lista[position].duration

        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailFilme::class.java)
            i.putExtra("obj", filme)
            context.startActivity(i)
        }


    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById(R.id.txtTitulo) as TextView
        val imgCover = itemView.findViewById(R.id.imgCover) as ImageView
        val txtYear = itemView.findViewById(R.id.txtAno) as TextView
        val txtDuration = itemView.findViewById(R.id.txtDuration) as TextView


    }

    }



