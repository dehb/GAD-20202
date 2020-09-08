package com.dehb.leaderboard

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel : ViewModel()  {

    private var _LearningLeaders = MutableLiveData<List<LearningHoursModel>>()
    val learningLeaders: LiveData<List<LearningHoursModel>> = _LearningLeaders
    fun getLearningLeader(context: Context){
        viewModelScope.launch{
            _LearningLeaders.value = Repository().getLearningLeaders(context)
        }
    }


    private var _SkillLeaders = MutableLiveData<List<SkillIqModel>>()
    val skillLeaders: LiveData<List<SkillIqModel>> = _SkillLeaders
    fun getSkillLeader(){
        viewModelScope.launch{
            _SkillLeaders.value = Repository().getSkillLeaders()
        }
    }
}