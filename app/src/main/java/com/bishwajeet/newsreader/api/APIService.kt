package com.bishwajeet.newsreader.api

import com.bishwajeet.newsreader.model.Article
import com.bishwajeet.newsreader.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


fun getNewsResponse(
    service: APIService,
    query: String,
    apiKey: String,
    page: Int,
    pageSize: Int,
    onSuccess: (repos: List<Article>) -> Unit,
    onError: (error: String) -> Unit
) {

    service.getNewsResponse(query, apiKey, page, pageSize).enqueue(
        object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                println("NETWORK: onFailure() -> ${t.message}")
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                println("NETWORK: onResponse() -> $response")
                if (response.isSuccessful) {
                    val news = response.body()?.articles ?: emptyList()
                    onSuccess(news)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )
}


interface APIService {

    @GET("top-headlines")
    fun getNewsResponse(
        @Query(value = "q") query: String,
        @Query(value = "apiKey") apiKey: String,
        @Query(value = "page") page: Int,
        @Query(value = "pageSize") pageSize: Int
    ): Call<NewsResponse>

    companion object Factory {

        private const val BASE_URL = "http://newsapi.org/v2/"

        fun create(): APIService {

            val retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(APIService::class.java)
        }
    }
}