package com.dehb.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.learning_list_item.view.*

class LearningRecyclerAdapter(private val learningLeaders: List<LearningHoursModel>, private val listLayout: Int): RecyclerView.Adapter<LearningRecyclerAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val personBadge = view.badge
        val personName= view.name
        val learnHours = view.hours
        val country = view.country
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(listLayout, parent, false)
        )

    }

    override fun getItemCount(): Int {
    return learningLeaders.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.personBadge =learningLeaders[position].badgeUrl
        holder.personName.text = learningLeaders[position].name
        holder.learnHours.text =learningLeaders[position].hours
        holder.country.text =learningLeaders[position].country
    }
}