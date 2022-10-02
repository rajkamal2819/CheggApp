package com.hackathon.chegg.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackathon.chegg.models.QuizModel
import com.hackathon.chegg.models.SelectedAnswers
import com.hackathon.chegg.services.api.QuizInterface
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.FieldPosition

class TestViewModel : ViewModel() {

    val questionsList: MutableLiveData<List<QuizModel>> = MutableLiveData(mutableListOf())
    val answersList: MutableLiveData<MutableList<SelectedAnswers>> = MutableLiveData(mutableListOf())
    val position: MutableLiveData<Int> = MutableLiveData(0)
    val score: MutableLiveData<Int> = MutableLiveData(0)
//

    object RetrofitHelper {

        val baseUrl = "https://quizapi.io/api/v1/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                // we need to add converter factory to
                // convert JSON object to Java object
                .build()
        }
    }

    fun checkAnswers(position: Int) {


            val correctAnswers = questionsList.value!![position].correctAnswers
            val selectedAnswers = answersList.value!![position]

        var sel=0
        var corr=0

            if (correctAnswers.answerACorrect.equals("true"))
                corr+=1
            if (correctAnswers.answerBCorrect.equals("true"))
                corr+=1
            if (correctAnswers.answerCCorrect.equals("true"))
                corr+=1
            if (correctAnswers.answerDCorrect.equals("true"))
                corr+=1
            if (correctAnswers.answerECorrect.equals("true"))
                corr+=1
            if (correctAnswers.answerFCorrect.equals("true"))
                corr+=1

            if (selectedAnswers.answerASelected.equals("true"))
                sel+=1
            if (selectedAnswers.answerBSelected.equals("true"))
                sel+=1
            if (selectedAnswers.answerCSelected.equals("true"))
                sel+=1
            if (selectedAnswers.answerDSelected.equals("true"))
                sel+=1
            if (selectedAnswers.answerESelected.equals("true"))
                sel+=1
            if (selectedAnswers.answerFSelected.equals("true"))
                sel+=1

        if (corr==sel)
            score.value=score.value!!+1



    }

//    fun setSubject(subject:String){
//        this.subject.value=subject
//    }

    fun increasePos() {
        position.value = position.value!! + 1
    }


    fun getQuizQuestions(subject: String) {
        val quizApi = RetrofitHelper.getInstance().create(QuizInterface::class.java)

        viewModelScope.launch {
            val response = quizApi.getQuiz(subject, "Easy")

            if (response.isSuccessful) {
                questionsList.value = response.body()
            } else
                Log.v("Error api", "Details are not fetched")


        }


    }
}