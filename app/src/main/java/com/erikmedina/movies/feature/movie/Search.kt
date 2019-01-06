package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.core.extension.unknown
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Search {

    @SerializedName("Title")
    @Expose
    var title: kotlin.String = String.unknown()
    @SerializedName("Year")
    @Expose
    var year: kotlin.String = String.unknown()
    @SerializedName("Rated")
    @Expose
    var rated: kotlin.String = String.unknown()
    @SerializedName("Released")
    @Expose
    var released: kotlin.String = String.unknown()
    @SerializedName("Runtime")
    @Expose
    var runtime: kotlin.String = String.unknown()
    @SerializedName("Genre")
    @Expose
    var genre: kotlin.String = String.unknown()
    @SerializedName("Director")
    @Expose
    var director: kotlin.String = String.unknown()
    @SerializedName("Writer")
    @Expose
    var writer: kotlin.String = String.unknown()
    @SerializedName("Actors")
    @Expose
    var actors: kotlin.String = String.unknown()
    @SerializedName("Plot")
    @Expose
    var plot: kotlin.String = String.unknown()
    @SerializedName("Language")
    @Expose
    var language: kotlin.String = String.unknown()
    @SerializedName("Country")
    @Expose
    var country: kotlin.String = String.unknown()
    @SerializedName("Awards")
    @Expose
    var awards: kotlin.String = String.unknown()
    @SerializedName("Poster")
    @Expose
    var poster: kotlin.String = String.unknown()
    @SerializedName("Ratings")
    @Expose
    var ratings: List<Rating> = emptyList()
    @SerializedName("Metascore")
    @Expose
    var metascore: kotlin.String = String.unknown()
    @SerializedName("imdbRating")
    @Expose
    var imdbRating: kotlin.String = String.unknown()
    @SerializedName("imdbVotes")
    @Expose
    var imdbVotes: kotlin.String = String.unknown()
    @SerializedName("imdbID")
    @Expose
    var imdbID: kotlin.String = String.unknown()
    @SerializedName("Type")
    @Expose
    var type: kotlin.String = String.unknown()
    @SerializedName("DVD")
    @Expose
    var dVD: kotlin.String = String.unknown()
    @SerializedName("BoxOffice")
    @Expose
    var boxOffice: kotlin.String = String.unknown()
    @SerializedName("Production")
    @Expose
    var production: kotlin.String = String.unknown()
    @SerializedName("Website")
    @Expose
    var website: kotlin.String = String.unknown()
    @SerializedName("Response")
    @Expose
    var response: kotlin.String = String.unknown()
}
