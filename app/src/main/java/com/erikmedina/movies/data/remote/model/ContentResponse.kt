package com.erikmedina.movies.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ContentResponse {

    @SerializedName("item")
    @Expose
    var search: Search = Search()
}
