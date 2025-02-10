package com.example.saneforcedoc.repo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel:ViewModel() {
    val repo = Repo()

    fun loadData(c:Context){
        viewModelScope.launch {
            repo.loadData(c)
        }
    }
    fun getDcoLiveData() = repo.getDoctors()
    fun getChemistLiveData() = repo.getChemist()



}