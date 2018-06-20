package com.obaap.googleplaceapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesAPI {
    @GET("maps/api/place/nearbysearch/json?location=17.4373252,78.4494391&radius=1500&key=AIzaSyCiH1NZGzqJE2T_X5CphQD3iazzrjJbL4A")
    fun getPlaces(@Query("type") type:String):Call<PlacesPOJO>
}