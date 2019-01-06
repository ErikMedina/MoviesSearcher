package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.core.extension.unknown
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchResponse {

    @SerializedName("Search")
    @Expose
    var movies: List<Search> = emptyList()
    @SerializedName("totalResults")
    @Expose
    var totalResults: kotlin.String = String.unknown()
    @SerializedName("Response")
    @Expose
    var response: kotlin.String = String.unknown()
}
