package com.hackathon.chegg.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackathon.chegg.models.QuizModel
import com.hackathon.chegg.services.api.QuizInterface
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestViewModel : ViewModel() {

    val questionsList: MutableLiveData<List<QuizModel>> = MutableLiveData()
//    val subject:MutableLiveData<String> = MutableLiveData()

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

//    fun setSubject(subject:String){
//        this.subject.value=subject
//    }


    fun getQuizQuestions(subject:String) {
        val quizApi = RetrofitHelper.getInstance().create(QuizInterface::class.java)

        viewModelScope.launch {
            val response = quizApi.getQuiz("CMS", "Easy")

            if (response.isSuccessful) {
                questionsList.value = response.body()
            } else
                Log.v("Error api", "Details are not fetched")


        }


    }
}