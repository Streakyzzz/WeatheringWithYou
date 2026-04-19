package com.example.weatheringwithyou.logic

import androidx.lifecycle.liveData
import com.example.weatheringwithyou.logic.model.Place
import com.example.weatheringwithyou.logic.network.WeatheringWithYouNetwork
import kotlinx.coroutines.Dispatchers

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = WeatheringWithYouNetwork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                //Result是kotlin提供用来分行装操作结果（成功/失败）的密封类，理论上不用Result封装也可以用，但封装后可以增加判断是不是由于status的原因报错，用于排查错误
                Result.success(places)
            }
            else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e: Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}