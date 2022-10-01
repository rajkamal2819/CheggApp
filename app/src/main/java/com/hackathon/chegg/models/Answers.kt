package com.hackathon.chegg.models

import com.google.gson.annotations.SerializedName

data class Answers(@SerializedName("answer_b")
                   val answerB: String? = null,
                   @SerializedName("answer_a")
                   val answerA: String? = null,
                   @SerializedName("answer_d")
                   val answerD: String? = null,
                   @SerializedName("answer_c")
                   val answerC: String? = null,
                   @SerializedName("answer_f")
                   val answerF: String? = null,
                   @SerializedName("answer_e")
                   val answerE: String? = null)