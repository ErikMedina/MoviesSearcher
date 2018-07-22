package com.erikmedina.article.data.local.model

import java.io.Serializable

/**
 * This class contains the item's details which are shown to the user.
 * Kotlin's Data Classes (https://kotlinlang.org/docs/reference/data-classes.html) are useful
 * for holding data.
 */
data class Item(
        val id: Int,
        val title: String,
        val subtitle: String,
        val body: String,
        val date: String
) : Serializable
