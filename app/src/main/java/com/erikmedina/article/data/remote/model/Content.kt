package com.erikmedina.article.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Content {

    @SerializedName("item")
    @Expose
    var item: Item? = null
}
