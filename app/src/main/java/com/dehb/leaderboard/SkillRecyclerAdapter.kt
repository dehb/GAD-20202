package com.dehb.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.skill_list_item.view.*

class SkillRecyclerAdapter(private val skillData:List<SkillIqModel>, private val listLayout: Int) : RecyclerView.Adapter<SkillRecyclerAdapter.ViewHolder>() {
    class ViewHolder( view: View): RecyclerView.ViewHolder(view){
val image = view.skill_badge
        val personName = view.skill_name
        val score = view.score
        val country = view.country
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(listLayout,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return skillData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = skillData[position].name
        holder.score.text = skillData[position].score
        holder.country.text = skillData[position].country
    }
}