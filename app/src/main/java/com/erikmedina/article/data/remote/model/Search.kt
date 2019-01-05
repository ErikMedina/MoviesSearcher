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
    @SerializedName("Rated")
    @Expose
    var rated: String = Constant.UNKNOWN
    @SerializedName("Released")
    @Expose
    var released: String = Constant.UNKNOWN
    @SerializedName("Runtime")
    @Expose
    var runtime: String = Constant.UNKNOWN
    @SerializedName("Genre")
    @Expose
    var genre: String = Constant.UNKNOWN
    @SerializedName("Director")
    @Expose
    var director: String = Constant.UNKNOWN
    @SerializedName("Writer")
    @Expose
    var writer: String = Constant.UNKNOWN
    @SerializedName("Actors")
    @Expose
    var actors: String = Constant.UNKNOWN
    @SerializedName("Plot")
    @Expose
    var plot: String = Constant.UNKNOWN
    @SerializedName("Language")
    @Expose
    var language: String = Constant.UNKNOWN
    @SerializedName("Country")
    @Expose
    var country: String = Constant.UNKNOWN
    @SerializedName("Awards")
    @Expose
    var awards: String = Constant.UNKNOWN
    @SerializedName("Poster")
    @Expose
    var poster: String = Constant.UNKNOWN
    @SerializedName("Ratings")
    @Expose
    var ratings: List<Rating> = emptyList()
    @SerializedName("Metascore")
    @Expose
    var metascore: String = Constant.UNKNOWN
    @SerializedName("imdbRating")
    @Expose
    var imdbRating: String = Constant.UNKNOWN
    @SerializedName("imdbVotes")
    @Expose
    var imdbVotes: String = Constant.UNKNOWN
    @SerializedName("imdbID")
    @Expose
    var imdbID: String = Constant.UNKNOWN
    @SerializedName("Type")
    @Expose
    var type: String = Constant.UNKNOWN
    @SerializedName("DVD")
    @Expose
    var dVD: String = Constant.UNKNOWN
    @SerializedName("BoxOffice")
    @Expose
    var boxOffice: String = Constant.UNKNOWN
    @SerializedName("Production")
    @Expose
    var production: String = Constant.UNKNOWN
    @SerializedName("Website")
    @Expose
    var website: String = Constant.UNKNOWN
    @SerializedName("Response")
    @Expose
    var response: String = Constant.UNKNOWN
}
