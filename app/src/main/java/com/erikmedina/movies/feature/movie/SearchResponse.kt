package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.core.util.Constant
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchResponse {

    @SerializedName("Search")
    @Expose
    var movies: List<Search> = emptyList()
    @SerializedName("totalResults")
    @Expose
    var totalResults: String = Constant.UNKNOWN
    @SerializedName("Response")
    @Expose
    var response: String = Constant.UNKNOWN
}