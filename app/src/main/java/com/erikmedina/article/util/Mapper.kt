package com.erikmedina.article.util

import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.data.remote.model.ContentResponse
import com.erikmedina.article.data.remote.model.SearchResponse

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

    fun mapItem(contentResponse: ContentResponse): Item {
        val item = contentResponse.search
        return Item(
                id = item.imdbID,
                title = item.title,
                poster = item.poster,
                actors = Constant.UNKNOWN,
                director = Constant.UNKNOWN,
                years = item.year,
        plot = item.plot
        )
    }
}
