package com.erikmedina.article.data.remote.model

import com.erikmedina.article.util.Constant
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Search {

    @SerializedName("Title")
    @Expose
    var title: String = Constant.UNKNOWN
    @SerializedName("Year")
    @Expose
    var year: String = Constant.UNKNOWN
    @SerializedName("imdbID")
    @Expose
    var imdbID: String = Constant.UNKNOWN
    @SerializedName("Type")
    @Expose
    var type: String = Constant.UNKNOWN
    @SerializedName("Poster")
    @Expose
    var poster: String = Constant.UNKNOWN
}
