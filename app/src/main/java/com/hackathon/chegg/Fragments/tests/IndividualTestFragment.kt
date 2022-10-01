package com.hackathon.chegg.Fragments.tests

import android.app.Activity
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hackathon.chegg.Adapters.IndividualQuestionsListAdapter
import com.hackathon.chegg.MainActivity

import com.hackathon.chegg.R
import com.hackathon.chegg.databinding.FragmentIndividualTestBinding
import com.hackathon.chegg.models.QuizModel
import com.hackathon.chegg.viewmodel.TestViewModel
import kotlin.math.log


class IndividualTestFragment : Fragment() {


    private lateinit var binding: FragmentIndividualTestBinding

    private val testViewModel:TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentIndividualTestBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility=View.GONE

        val bundle=this.arguments;

        if (bundle!=null)
        testViewModel.getQuizQuestions(bundle.getString("subject").toString())

        testViewModel.questionsList.observe(viewLifecycleOwner) {
            Log.v("List details", it.toString())
            binding.questionsRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            binding.questionsRecyclerView.adapter=IndividualQuestionsListAdapter(it)
        }





        snapHelper()
    }

    fun snapHelper(){
        val snapHelper=PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.questionsRecyclerView)

        binding.questionsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val view=snapHelper.findSnapView(recyclerView.layoutManager)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }


}