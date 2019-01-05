package com.erikmedina.article.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchResponse {

    @SerializedName("items")
    @Expose
    var searches: List<Search> = emptyList()
}
