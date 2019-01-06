package com.erikmedina.movies.feature.movie

import android.os.Bundle
import com.erikmedina.movies.R
import com.erikmedina.movies.core.platform.BaseActivity
import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.core.util.Constant
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailActivity : BaseActivity() {

    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = intent.getSerializableExtra(Constant.EXTRA_ITEM) as Item
        initializeItemDetail()
    }

    private fun initializeItemDetail() {
        tvTitle.text = item.title
        tvPoster.text = item.poster
        tvBody.text = item.plot
        tvYear.text = item.years
    }

    override fun getLayoutId() = R.layout.activity_item_detail
}
