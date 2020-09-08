package com.dehb.leaderboard

import android.content.Context
import android.util.Log
import retrofit2.create

class Repository {

    suspend fun getLearningLeaders(context: Context): List<LearningHoursModel>{
        val apiService = RetrofitFactory.getRetrofitInstance(

        ).create(ApiInterface::class.java)
        val response = apiService.getLearningHours()
        val responseBody = response.body()!!
        Log.i("Response_learn", response.toString())
        Log.i("Response_learnBody", responseBody.toString())
        return responseBody
    }

    suspend fun getSkillLeaders(): List<SkillIqModel> {
        val apiService = RetrofitFactory.getRetrofitInstance().create(ApiInterface::class.java)
        val response = apiService.getSkillIq()
        val responseBody = response.body()!!
        Log.i("Response_skill", response.toString())
        Log.i("Response_skillBody", responseBody.toString())
        return responseBody
    }
}