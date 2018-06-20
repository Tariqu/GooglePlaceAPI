package com.obaap.googleplaceapi

import com.google.gson.annotations.SerializedName

data class PlacesPOJO(@SerializedName("next_page_token")
                      val nextPageToken: String = "",
                      @SerializedName("results")
                      val results: List<ResultsItem>?,
                      @SerializedName("status")
                      val status: String = "")