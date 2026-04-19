package com.example.weatheringwithyou.logic.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status:String,val places:List<Place>)

/*
获取的Place形式是这样的：
{"status":"ok","query":"北京",
"places":[
{"name":"北京市","location":{"lat":39.9041999,"lng":116.4073963},
"formatted_address":"中国北京市"},
{"name":"北京西站","location":{"lat":39.89491,"lng":116.322056},
"formatted_address":"中国 北京市 丰台区 莲花池东路118号"},
{"name":"北京南站","location":{"lat":39.865195,"lng":116.378545},
"formatted_address":"中国 北京市 丰台区 永外大街车站路12号"},
{"name":"北京站(地铁站)","location":{"lat":39.904983,"lng":116.427287},
"formatted_address":"中国 北京市 东城区 2号线"}
]}
*/

data class Place(val name: String,val location:Location,
//这个注解让服务器的json字段和Kotlin字段之间建立映射关系
    @SerializedName("formatted_address") val address:String)

data class Location(val lng:String,val lat: String)//经纬度