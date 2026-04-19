package com.example.weatheringwithyou.logic.network

import com.example.weatheringwithyou.WeatheringWithYouApplication
import com.example.weatheringwithyou.logic.model.Place
import com.example.weatheringwithyou.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//Retrofit接口的命名习惯用具体功能为开头，Service为结尾，如这个是获取的Place信息
interface PlaceService {
    @GET("v2/place")
    fun searchPlaces(@Query("query") query:String,
                     @Query("token") token: String = WeatheringWithYouApplication.TOKEN,
                     @Query("lang") lang:String = "zh_CN"
    ): Call<PlaceResponse>
}