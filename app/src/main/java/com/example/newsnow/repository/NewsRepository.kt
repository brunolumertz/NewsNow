package com.example.newsnow.repository

import com.example.newsnow.api.RetrofitInstance
import com.example.newsnow.database.ArticleDatabase
import com.example.newsnow.model.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    //vai puxar as news salvas
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    //Deleta do BD
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}