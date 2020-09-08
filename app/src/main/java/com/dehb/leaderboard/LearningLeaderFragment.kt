package com.dehb.leaderboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
//import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.fragment_learing_leaders.view.*

class LearningLeaderFragment : Fragment() {
    val viewModel: ViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getLearningLeader(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_learing_leaders, container, false)

//        setUpRecycler(root.learning_recycler)
        viewModel.learningLeaders.observe(viewLifecycleOwner, Observer<List<LearningHoursModel>>{
           val learningLeaders = it ?: return@Observer
            Log.i("Response_observer", learningLeaders.toString())

//            if (learningLeaders.isNullOrEmpty()){
//                timetable_fragment.addView(View.inflate(context, R.layout.empty_response_view, null ))
//            } else {
            setUpRecycler(root.learning_recycler, learningLeaders)

//            }
        })
        return root
    }


    private fun setUpRecycler(view: RecyclerView, learningData: List<LearningHoursModel>) = with(view){
        layoutManager = LinearLayoutManager(context)
        adapter = LearningRecyclerAdapter(learningData, R.layout.learning_list_item)
    }
}