package com.hackathon.chegg.Fragments.tests

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.chegg.Adapters.IndividualQuestionsListAdapter
import com.hackathon.chegg.R
import com.hackathon.chegg.databinding.FragmentIndividualTestBinding
import com.hackathon.chegg.viewmodel.TestViewModel
import ir.samanjafari.easycountdowntimer.CountDownInterface


class IndividualTestFragment : Fragment() {


    private lateinit var binding: FragmentIndividualTestBinding

    private val testViewModel:TestViewModel by activityViewModels()

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

//        (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottom_navigation).visibility=View.GONE

        val bundle=this.arguments;

        Log.v("Bundle",bundle?.getString("subject").toString())
        if (bundle!=null)
        testViewModel.getQuizQuestions(bundle.getString("subject").toString())

        binding.topicName.text=bundle?.getString("subject").toString()

        testViewModel.questionsList.observe(viewLifecycleOwner) {
            Log.v("List details", it.toString())
            binding.questionsRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            binding.questionsRecyclerView.adapter=IndividualQuestionsListAdapter(it,testViewModel)
        }


        val pasueOffset=SystemClock.elapsedRealtime()-binding.chronometer.base
        binding.chronometer.base=SystemClock.elapsedRealtime()-pasueOffset

        binding.chronometer.start()
        testViewModel.position.value=0
        binding.nextButton.setOnClickListener{
            testViewModel.checkAnswers(testViewModel.position.value!!)
            testViewModel.increasePos()
            if(testViewModel.position.value!!>= testViewModel.questionsList.value!!.size){

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,ResultFragment())
                    .commit()
            }
            binding.questionsRecyclerView.scrollToPosition(testViewModel.position.value!!)
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