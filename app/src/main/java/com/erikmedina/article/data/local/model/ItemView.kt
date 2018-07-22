package com.erikmedina.article.data.local.model

import com.erikmedina.article.util.Constant
import java.io.Serializable

/**
 * This class contains the item's details which are shown to the user.
 * Kotlin's Data Classes (https://kotlinlang.org/docs/reference/data-classes.html) are useful
 * for holding data.
 */
data class ItemView(
        val id: Int,
        val title: String = Constant.UNKNOWN,
        val subtitle: String = Constant.UNKNOWN,
        val date: String = Constant.UNKNOWN
) : Serializable
