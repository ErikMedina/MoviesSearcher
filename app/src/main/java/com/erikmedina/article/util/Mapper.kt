package com.erikmedina.article.util

import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.data.remote.model.SearchResponse
import com.erikmedina.article.data.remote.model.ContentResponse

object Mapper {

    fun mapItems(searchResponse: SearchResponse): List<Item> {
        val items = searchResponse.searches
        val itemViews = ArrayList<Item>()
        for (item in items) {
            val itemView = Item(
                    id = item.id,
                    title = item.title,
                    subtitle = item.subtitle,
                    body = item.body,
                    date = item.date
            )
            itemViews.add(itemView)
        }
        return itemViews
    }

    fun mapItem(contentResponse: ContentResponse): Item {
        val item = contentResponse.search
        return Item(
                id = item.id,
                title = item.title,
                subtitle = item.subtitle,
                body = item.body,
                date = item.date
        )
    }
}
