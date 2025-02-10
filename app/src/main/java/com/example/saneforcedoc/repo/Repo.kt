package com.example.saneforcedoc.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repo {

    private var doctorsLiveData = MutableLiveData<List<Doctor>>()
    private var chemistLiveData = MutableLiveData<List<Chemist>>()


    private lateinit var context:Context

    suspend fun loadData(c:Context){
        context = c
        coroutineScope {
            async {  fetchDoctorFromRoom() }
            async {  fetchChemistFromRoom() }
            async {  fetchDoctorFromApi()}
            async {  fetchChemistFromApi()}

        }

    }



    fun getDoctors() = doctorsLiveData
    fun getChemist() = chemistLiveData

    private  fun fetchDoctorFromApi(){
        val call = RetrofitWeb.api.getDoctor(DocPostBody())

        call.enqueue(object : Callback<DocResponse> {
            override fun onResponse(call: Call<DocResponse>, response: Response<DocResponse>) {
                if (response.isSuccessful){
                    val doctors = response.body()
                    Log.d("DOCRESP", "onResponse: ${doctors}")
                    doctors?.response.also {
                        doctorsLiveData.postValue ( it )
                    saveProductInRoom(it!!)
                    }

                }
            }
            override fun onFailure(call: Call<DocResponse>, t: Throwable) {
                Log.e("DOCRESP", "onFailure: ${t.message} ", )
            }
        })
    }

    private fun fetchChemistFromApi(){
        val call = RetrofitWeb.api.getChemist(ChemistPostBody())

        call.enqueue(object : Callback<ChemistResponse> {
            override fun onResponse(call: Call<ChemistResponse>, response: Response<ChemistResponse>) {
                if (response.isSuccessful){
                    val chemist = response.body()
                    Log.d("DOCRESP", "onResponse: ${chemist}")
                    chemist?.response.also {
                        chemistLiveData.postValue ( it )
                        saveChemistInRoom(it!!)
                    }

                }
            }
            override fun onFailure(call: Call<ChemistResponse>, t: Throwable) {
                Log.e("DOCRESP", "onFailure: ${t.message} ", )
            }
        })
    }

    private suspend fun fetchDoctorFromRoom() {
            DatabaseBuilder.run {
                doctorsLiveData.postValue(getInstance(context).productDao().getAllProducts())
        }

    }
    private suspend fun fetchChemistFromRoom() {
            DatabaseBuilder.run {
                chemistLiveData.postValue(getInstance(context).chemistDao().getAllProducts())

        }

    }

     fun saveProductInRoom(body: List<Doctor>) {
         GlobalScope.launch {
             DatabaseBuilder.run {
                 getInstance(context).productDao().insertProducts(body)
             }
         }
    }
    fun saveChemistInRoom(body: List<Chemist>) {
        GlobalScope.launch {
            DatabaseBuilder.run {
                getInstance(context).chemistDao().insertProducts(body)
            }
        }
    }



}