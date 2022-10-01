package com.hackathon.chegg.models

import com.google.gson.annotations.SerializedName

data class QuizModel(@SerializedName("difficulty")
                     val difficulty: String = "",
                     @SerializedName("question")
                     val question: String = "",
                     @SerializedName("multiple_correct_answers")
                     val multipleCorrectAnswers: String = "",
                     @SerializedName("answers")
                     val answers: Answers,
                     @SerializedName("description")
                     val description: String = "",
                     @SerializedName("correct_answers")
                     val correctAnswers: CorrectAnswers,
                     @SerializedName("tip")
                     val tip: List<String>? = null,
                     @SerializedName("id")
                     val id: Int = 0,
                     @SerializedName("explanation")
                     val explanation: String = "",
                     @SerializedName("category")
                     val category: String = "")