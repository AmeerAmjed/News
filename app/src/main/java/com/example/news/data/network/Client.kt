package com.example.news.data.network

import com.example.news.data.model.NewsModel
import com.example.news.ui.util.Constants
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class Client {
    private val client = OkHttpClient()

    fun getDataNews(): State<NewsModel?> {
        val request = Request.Builder().url(Constants.Api.URL).build()
        val response =  client.newCall(request).execute()
        return if (response.isSuccessful){

            val result = Gson().fromJson( response.body?.string(), NewsModel::class.java)
            State.Success(result)

        } else{
            State.Error(response.message)
        }
    }
}