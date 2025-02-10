package com.example.saneforcedoc.repo

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Apis {

    @Headers("Content-Type: application/json")
    @POST("DEV/MasterSync")
    fun getDoctor(@Body data: DocPostBody):Call<DocResponse>

    @Headers("Content-Type: application/json")
    @POST("DEV/MasterSync")
    fun getChemist(@Body data: ChemistPostBody):Call<ChemistResponse>

}