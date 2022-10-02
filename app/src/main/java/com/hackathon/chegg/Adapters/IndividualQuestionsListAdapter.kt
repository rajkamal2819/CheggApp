package com.hackathon.chegg.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.chegg.databinding.IndividualQuestionsBinding
import com.hackathon.chegg.models.Answers
import com.hackathon.chegg.models.CorrectAnswers
import com.hackathon.chegg.models.QuizModel
import com.hackathon.chegg.models.SelectedAnswers
import com.hackathon.chegg.viewmodel.TestViewModel


class IndividualQuestionsListAdapter(
    val questionsList: List<QuizModel>,
    val testViewModel: TestViewModel
) :
    RecyclerView.Adapter<IndividualQuestionsListAdapter.OptionsListViewHolder>() {


    class OptionsListViewHolder(
        val binding: IndividualQuestionsBinding,
        val testViewModel: TestViewModel
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(
            options: Answers,
            question: String,
            position: Int,
            size: Int,

        ) {

            binding.questionNo.text = "Question $position/$size"


            if (!options.answerA.isNullOrEmpty()) {
                binding.mtrlCard1.visibility = View.VISIBLE
                binding.checkBox1.text = options.answerA
            }
            if (!options.answerB.isNullOrEmpty()) {
                binding.mtrlCard2.visibility = View.VISIBLE
                binding.checkBox2.text = options.answerB
            }
            if (!options.answerC.isNullOrEmpty()) {
                binding.mtrlCard3.visibility = View.VISIBLE
                binding.checkBox3.text = options.answerC
            }
            if (!options.answerD.isNullOrEmpty()) {
                binding.mtrlCard4.visibility = View.VISIBLE
                binding.checkBox4.text = options.answerD

            }
            if (!options.answerE.isNullOrEmpty()) {
                binding.mtrlCard5.visibility = View.VISIBLE
                binding.checkBox5.text = options.answerE
            }
            if (!options.answerF.isNullOrEmpty()) {
                binding.mtrlCard6.visibility = View.VISIBLE
                binding.checkBox6.text = options.answerF
            }

            binding.question.text = question

            val selectedAnswers=SelectedAnswers()
            binding.checkBox1.setOnClickListener { selectedAnswers.answerASelected=binding.checkBox1.isChecked.toString() }
            binding.checkBox2.setOnClickListener { selectedAnswers.answerBSelected=binding.checkBox2.isChecked.toString() }
            binding.checkBox3.setOnClickListener { selectedAnswers.answerCSelected=binding.checkBox3.isChecked.toString() }
            binding.checkBox4.setOnClickListener { selectedAnswers.answerDSelected=binding.checkBox4.isChecked.toString() }
            binding.checkBox5.setOnClickListener { selectedAnswers.answerESelected=binding.checkBox5.isChecked.toString() }
            binding.checkBox6.setOnClickListener { selectedAnswers.answerFSelected=binding.checkBox6.isChecked.toString() }

            testViewModel.answersList.value!!.add(selectedAnswers)

//            testViewModel.answersList.value!!.set(
//                position,
//                SelectedAnswers(
//                    binding.checkBox1.isChecked.toString(),
//                    binding.checkBox2.isChecked.toString(),
//                    binding.checkBox3.isChecked.toString(),
//                    binding.checkBox4.isChecked.toString(),
//                    binding.checkBox5.isChecked.toString(),
//                    binding.checkBox6.isChecked.toString()
//                )
//            )


        }

        override fun onClick(p0: View?) {

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsListViewHolder {


        val binding = IndividualQuestionsBinding.inflate(LayoutInflater.from(parent.context))

        return OptionsListViewHolder(binding, testViewModel)
    }

    override fun onBindViewHolder(holder: OptionsListViewHolder, position: Int) {


        holder.bind(
            questionsList[position].answers,
            questionsList[position].question,
            position + 1,
            questionsList.size,

        )


    }

    override fun getItemCount(): Int {
        return questionsList.size
    }
}