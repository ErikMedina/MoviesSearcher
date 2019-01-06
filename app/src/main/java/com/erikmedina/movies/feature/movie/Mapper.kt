package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.data.remote.model.Search
import com.erikmedina.movies.data.remote.model.SearchResponse
import com.erikmedina.movies.core.util.Constant

object Mapper {

    fun mapItems(searchResponse: SearchResponse): List<Item> {
        val movies = searchResponse.movies
        val itemViews = ArrayList<Item>()
        for (movie in movies) {
            val itemView = Item(
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

    fun mapItem(search: Search): Item {
        return Item(
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
