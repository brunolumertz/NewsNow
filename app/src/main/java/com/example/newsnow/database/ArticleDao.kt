package com.example.newsnow.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsnow.model.Article

@Dao
interface ArticleDao {

    //Att/insere article no BD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    //Retorna do BD
    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    //Deleta
    @Delete
    suspend fun deleteArticle(article: Article)
}