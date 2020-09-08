package com.dehb.leaderboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dehb.leaderboard.ui.main.PageViewModel
import kotlinx.android.synthetic.main.fragment_skill_leaders.view.*


class SkillLeaderFragment : Fragment() {
    val viewModel: ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getSkillLeader()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_skill_leaders, container, false)

        viewModel.skillLeaders.observe(viewLifecycleOwner, Observer<List<SkillIqModel>>{
            val skillIQ = it ?: return@Observer
            setUpRecycler(root.skill_recycler, skillIQ)
        })


        return root
    }
    private fun setUpRecycler(view: RecyclerView, skillData: List<SkillIqModel>) = with(view){
        layoutManager = LinearLayoutManager(context)
        adapter = SkillRecyclerAdapter(skillData, R.layout.skill_list_item)
    }

}