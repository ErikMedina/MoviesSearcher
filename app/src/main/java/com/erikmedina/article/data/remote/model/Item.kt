package com.erikmedina.article.data.remote.model

import com.erikmedina.article.util.Constant
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Item {

    @SerializedName("id")
    @Expose
    var id: Int = -1
    @SerializedName("title")
    @Expose
    var title: String = Constant.UNKNOWN
    @SerializedName("subtitle")
    @Expose
    var subtitle: String = Constant.UNKNOWN
    @SerializedName("body")
    @Expose
    var body: String = Constant.UNKNOWN
    @SerializedName("date")
    @Expose
    var date: String = Constant.UNKNOWN
}
