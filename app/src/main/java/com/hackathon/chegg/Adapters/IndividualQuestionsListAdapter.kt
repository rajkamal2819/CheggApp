package com.hackathon.chegg.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.chegg.databinding.IndividualQuestionsBinding
import com.hackathon.chegg.models.Answers
import com.hackathon.chegg.models.QuizModel


class IndividualQuestionsListAdapter(val questionsList: List<QuizModel>) :
    RecyclerView.Adapter<IndividualQuestionsListAdapter.OptionsListViewHolder>() {

    class OptionsListViewHolder(val binding: IndividualQuestionsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(options: Answers, question: String, position: Int, size: Int) {

            binding.questionNo.text = "Question $position/$size"


            if (!options.answerA.isNullOrEmpty()) {
                binding.mtrlCard1.visibility=View.VISIBLE
               binding.checkBox1.text=options.answerA
            }
            if (!options.answerB.isNullOrEmpty()) {
                binding.mtrlCard2.visibility=View.VISIBLE
                binding.checkBox2.text=options.answerB
            }
            if (!options.answerC .isNullOrEmpty()) {
                binding.mtrlCard3.visibility=View.VISIBLE
                binding.checkBox3.text=options.answerC
            }
            if (!options.answerD.isNullOrEmpty()) {
                binding.mtrlCard4.visibility=View.VISIBLE
                binding.checkBox4.text=options.answerD

            }
            if (!options.answerE.isNullOrEmpty()) {
                binding.mtrlCard5.visibility=View.VISIBLE
                binding.checkBox5.text=options.answerE
            }
            if (!options.answerF .isNullOrEmpty()) {
                binding.mtrlCard6.visibility=View.VISIBLE
                binding.checkBox6.text=options.answerF
            }

            binding.question.text = question
        }

        fun onOptionsClick() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsListViewHolder {


        val binding = IndividualQuestionsBinding.inflate(LayoutInflater.from(parent.context))

        return OptionsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OptionsListViewHolder, position: Int) {


        holder.bind(
            questionsList[position].answers,
            questionsList[position].question,
            position + 1,
            questionsList.size
        )
    }

    override fun getItemCount(): Int {
        return questionsList.size
    }
}