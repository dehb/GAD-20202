package com.dehb.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LearningRecyclerAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.learning_list_item, parent, false)
        )

    }

    override fun getItemCount(): Int =15

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}