package com.example.awesomemoviesearch.network

import androidx.room.Query
import com.example.awesomemoviesearch.Constants
import com.example.awesomemoviesearch.data.MovieResponse
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object Network {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(Constants.BASE_URL)
        .build()

    val movies: MovieAPIService = retrofit.create(MovieAPIService::class.java)
}

interface MovieAPIService {
    @GET
    suspend fun getMovies(
        @Query("api_key")
        apiKey:String = BuildConfig.API_KEY,
        @
    ): MovieResponse

}