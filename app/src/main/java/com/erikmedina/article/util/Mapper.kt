package com.erikmedina.article.util

import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.data.remote.model.ContentListResponse
import com.erikmedina.article.data.remote.model.ContentResponse

object Mapper {

    fun map(contentListResponse: ContentListResponse): List<Item> {
        val items = contentListResponse.items
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
        val item = contentResponse.item
        return Item(
                id = item.id,
                title = item.title,
                subtitle = item.subtitle,
                body = item.body,
                date = item.date
        )
    }
}
