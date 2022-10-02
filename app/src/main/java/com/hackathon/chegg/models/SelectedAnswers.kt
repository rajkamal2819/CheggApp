package com.hackathon.chegg.models

import com.google.gson.annotations.SerializedName

data class SelectedAnswers(
    var answerDSelected: String = "",
    var answerCSelected: String = "",
    var answerFSelected: String = "",
    var answerBSelected: String = "",
    var answerASelected: String = "",
    var answerESelected: String = "")
