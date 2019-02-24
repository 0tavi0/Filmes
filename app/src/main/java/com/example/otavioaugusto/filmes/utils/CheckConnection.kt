package com.example.otavioaugusto.filmes.utils

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AlertDialog

class CheckConnection {

    companion object {

        fun isNetworkConnected(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }

        fun alerta(title:String, mensage:String, context: Context){
            var myAlertBuilder = AlertDialog.Builder(context)

            myAlertBuilder.setTitle(title)

            myAlertBuilder.setMessage(mensage)
            myAlertBuilder.setPositiveButton("Ok") { dialog, which ->
            }

            val dialog = myAlertBuilder.create()
            dialog.show()
        }

    }

    }