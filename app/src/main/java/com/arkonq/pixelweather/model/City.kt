package com.arkonq.pixelweather.model

import com.google.gson.annotations.SerializedName

class City(
        @SerializedName("country") var country: String,
        @SerializedName("name") var name: String,
        @SerializedName("id") var id: Int
)