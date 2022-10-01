package com.hackathon.chegg.services.api

import com.google.android.gms.common.api.Response
import com.hackathon.chegg.models.QuizModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuizInterface {
    @GET("questions?apiKey=PdifjZX3OgnhinHZtd7VH5s8xGUbfDWmyqISmjQq&category=&difficulty=&limit=10")
    suspend fun getQuiz(@Query("category") subject:String, @Query("difficulty")difficulty:String):retrofit2.Response<List<QuizModel>>
}