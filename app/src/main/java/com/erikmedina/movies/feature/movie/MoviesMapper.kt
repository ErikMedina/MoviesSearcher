package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.core.extension.unknown

object MoviesMapper {

    fun mapMovies(searchResponse: SearchResponse): List<Movie> {
        val movies = searchResponse.movies
        val itemViews = ArrayList<Movie>()
        for (movie in movies) {
            val itemView = Movie(
                    id = movie.imdbID,
                    title = movie.title,
                    actors = String.unknown(),
                    director = String.unknown(),
                    poster = movie.poster,
                    years = movie.year,
                    plot = String.unknown()
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
