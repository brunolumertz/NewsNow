package com.example.newsnow.api

import com.example.newsnow.Constants.Companion.KEY
import com.example.newsnow.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode:String = "br",
        @Query("page")
        pageNumber:Int = 1,
        @Query("apiKey")
        apikey:String = KEY
    ): Response<NewsResponse>


    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery:String ,
        @Query("page")
        pageNumber:Int = 1,
        @Query("apiKey")
        apikey:String = KEY
    ): Response<NewsResponse>
}