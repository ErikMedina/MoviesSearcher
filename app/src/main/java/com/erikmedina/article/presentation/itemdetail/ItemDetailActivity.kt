package com.erikmedina.article.presentation.itemdetail

import android.os.Bundle
import com.erikmedina.article.R
import com.erikmedina.article.data.local.model.ItemView
import com.erikmedina.article.presentation.BaseActivity
import com.erikmedina.article.util.Constant
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailActivity : BaseActivity() {

    private lateinit var itemView: ItemView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemView = intent.getSerializableExtra(Constant.EXTRA_ITEM) as ItemView
        initializeItemDetail()
    }

    private fun initializeItemDetail() {
        tvTitle.text = itemView.title
        tvSubtitle.text = itemView.subtitle
        tvBody.text = itemView.body
        tvDate.text = itemView.date
    }

    override fun getLayoutId() = R.layout.activity_item_detail

    override fun initializeDependencyInjector() {
        //TODO: we have to create the Dagger module for this activity so we can inject the presenter, interactors,...
    }
}
