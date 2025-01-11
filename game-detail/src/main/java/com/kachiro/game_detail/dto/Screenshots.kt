package com.kachiro.game_detail.dto

import com.google.gson.annotations.SerializedName

data class Screenshots (

  @SerializedName("id"    ) var id    : Int?    = null,
  @SerializedName("image" ) var image : String? = null

)