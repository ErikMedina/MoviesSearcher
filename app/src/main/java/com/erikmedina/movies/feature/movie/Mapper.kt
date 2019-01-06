package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.core.util.Constant

object Mapper {

    fun mapMovies(searchResponse: SearchResponse): List<Movie> {
        val movies = searchResponse.movies
        val itemViews = ArrayList<Movie>()
        for (movie in movies) {
            val itemView = Movie(
                    id = movie.imdbID,
                    title = movie.title,
                    actors = Constant.UNKNOWN,
                    director = Constant.UNKNOWN,
                    poster = movie.poster,
                    years = movie.year,
                    plot = Constant.UNKNOWN
            )
            itemViews.add(itemView)
        }
        return itemViews
    }

    fun mapMovie(search: Search): Movie {
        return Movie(
                id = search.imdbID,
                title = search.title,
                poster = search.poster,
                actors = search.actors,
                director = search.director,
                years = search.year,
                plot = search.plot
        )
    }
}
