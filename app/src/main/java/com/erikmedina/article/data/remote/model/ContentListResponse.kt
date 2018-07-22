package com.erikmedina.article.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ContentListResponse {

    @SerializedName("items")
    @Expose
    var items: List<Item> = emptyList()
}
