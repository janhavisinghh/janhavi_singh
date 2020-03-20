package com.truecaller.janhavi_singh

import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("2018/01/22/life-as-an-android-engineer/")
    fun getStringResponse(): Call<String>
}