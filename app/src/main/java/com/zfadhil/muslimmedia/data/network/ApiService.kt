package com.zfadhil.muslimmedia.data.network

import com.zfadhil.muslimmedia.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getCommonMuslimNews(
        @Query("q") query: String = "indonesia",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("pageSize") pageSize: Int = 30,
    ) : Call<NewsResponse>

    @GET("everything")
    fun getAboutQuranNews(
        @Query("q") query: String = "indonesia",
        @Query("sortBy") sortBy: String = "popularity"
    ) : Call<NewsResponse>

    @GET("top-headlines")
    fun getAlJazeeraNews(
        @Query("domains") domains: String = "liputan6.com,kapanlagi.com,detik.com,suara.com,sindonews.com"
    ) : Call<NewsResponse>

    @GET("everything")
    fun getWarningForIslam(
        @Query("q") keyword: String = "viral"
    ) : Call<NewsResponse>

    @GET("everything")
    fun searchNews(
        @Query("q") query: String
    ) : Call<NewsResponse>
}