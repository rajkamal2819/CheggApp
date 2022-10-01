package com.hackathon.chegg.models

import com.google.gson.annotations.SerializedName

data class CorrectAnswers(@SerializedName("answer_d_correct")
                          val answerDCorrect: String = "",
                          @SerializedName("answer_c_correct")
                          val answerCCorrect: String = "",
                          @SerializedName("answer_f_correct")
                          val answerFCorrect: String = "",
                          @SerializedName("answer_b_correct")
                          val answerBCorrect: String = "",
                          @SerializedName("answer_a_correct")
                          val answerACorrect: String = "",
                          @SerializedName("answer_e_correct")
                          val answerECorrect: String = "")