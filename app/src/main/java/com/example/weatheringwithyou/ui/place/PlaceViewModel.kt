package com.example.weatheringwithyou.ui.place
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.weatheringwithyou.logic.Repository
import com.example.weatheringwithyou.logic.model.Place

class PlaceViewModel: ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = searchLiveData.switchMap { query -> Repository.searchPlaces(query) }//Transformations被删除了，直接用switchMap

    fun searchPlaces(query: String){
        searchLiveData.value = query
    }

}