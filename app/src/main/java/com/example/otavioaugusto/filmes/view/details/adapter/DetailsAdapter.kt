package com.example.otavioaugusto.filmes.view.details.adapter

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

class DetailsAdapter(val lista:List<String>, val context: Context):RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_details, parent, false)
        val ivh = ViewHolder(v)
        return ivh
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            Picasso.get()
                .load(lista[position])
                .into(holder.imgCover)

        }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imgCover = itemView.findViewById(R.id.imgDetails) as ImageView

    }

    }



