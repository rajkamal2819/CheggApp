package com.hackathon.chegg.Fragments.tests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.hackathon.chegg.R
import com.hackathon.chegg.databinding.FragmentResultBinding
import com.hackathon.chegg.viewmodel.TestViewModel


class ResultFragment : Fragment() {

    private lateinit var binding:FragmentResultBinding
    private val testViewModel:TestViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentResultBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val score=testViewModel.score.value.toString()
        val no=testViewModel.questionsList.value!!.size
       // testViewModel.checkAnswers()
        binding.scoreText.text="Your current score is: $score/$no"

        binding.nextButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,Test_Fragment())
                .commit()
        }

    }


}