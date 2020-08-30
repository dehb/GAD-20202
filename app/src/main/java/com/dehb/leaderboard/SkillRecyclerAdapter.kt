package com.dehb.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView

class SkillRecyclerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ViewHolder( view: View): RecyclerView.ViewHolder(view){

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.skill_list_item,parent,false)
        )
    }

    override fun getItemCount(): Int =10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}