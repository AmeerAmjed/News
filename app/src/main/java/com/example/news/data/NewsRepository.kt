package com.example.news.data

import com.example.news.data.model.NewsModel
import com.example.news.data.network.Client
import com.example.news.data.network.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepository {
    private val client = Client()
    fun getNews(): Flow<State<NewsModel?>> = flow {
        emit(State.Loading)
        emit(client.getDataNews())
    }.flowOn(Dispatchers.IO)
}