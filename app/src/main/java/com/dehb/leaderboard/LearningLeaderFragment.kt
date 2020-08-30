package com.dehb.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_learing_leaders.*
import kotlinx.android.synthetic.main.fragment_learing_leaders.view.*

class LearningLeaderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_learing_leaders, container, false)

        setUpRecycler(root.learning_recycler)
        return root
    }


    private fun setUpRecycler(view: RecyclerView) = with(view){
        layoutManager = LinearLayoutManager(context)
        adapter = LearningRecyclerAdapter()
    }
}