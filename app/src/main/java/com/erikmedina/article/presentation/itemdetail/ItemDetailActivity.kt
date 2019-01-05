package com.erikmedina.article.presentation.itemdetail

import android.os.Bundle
import com.erikmedina.article.R
import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.presentation.BaseActivity
import com.erikmedina.article.util.Constant
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

    override fun initializeDependencyInjector() {
        //TODO: we have to create the Dagger module for this activity so we can inject the presenter, interactors,...
    }
}
