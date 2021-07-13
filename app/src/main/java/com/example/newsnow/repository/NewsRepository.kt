package com.example.newsnow.repository

import com.example.newsnow.api.RetrofitInstance
import com.example.newsnow.database.ArticleDatabase

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}