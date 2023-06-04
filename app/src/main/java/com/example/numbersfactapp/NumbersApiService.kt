package com.example.numbersfactapp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.lang.reflect.Type
import java.math.BigDecimal
import kotlin.math.pow

private const val BASE_URL = "http://numbersapi.com"



private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface NumbersApiService {

    @GET("/{number}/trivia?json")
    suspend fun getFact(@Path("number") number: Int): NumberFact

    @GET("/random/trivia?json")
    suspend fun getRandomFact(): NumberFact

}

object NumbersApi{
    val retrofitService: NumbersApiService by lazy {
        retrofit.create(NumbersApiService::class.java)
    }
}