package com.bishwajeet.newsreader.api

import android.util.Log
import com.bishwajeet.newsreader.model.Article
import com.bishwajeet.newsreader.model.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


fun getNewsResponse(service: APIService,
                    country: String,
                    apiKey: String,
                    page: Int,
                    onSuccess: (repos: List<Article>) -> Unit,
                    onError: (error: String) -> Unit) {

    service.getNewsResponse(country, apiKey, page).enqueue(
        object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d("NETWORK", "onFailure() -> ${t.message}")
                onError(t.message ?:"unknown error")
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                Log.d("NETWORK", "onResponse() -> $response")
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
        @Query(value = "country") country: String,
        @Query(value = "apiKey") apiKey: String,
        @Query(value = "page") page: Int
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