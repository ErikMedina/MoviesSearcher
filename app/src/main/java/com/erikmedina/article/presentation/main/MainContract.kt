package com.erikmedina.article.presentation.main

import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.presentation.BasePresenter
import com.erikmedina.article.presentation.BaseView

/**
 * This interface specifies the contract between the view and the presenter.
 */

interface MainContract {

    interface View : BaseView<Presenter> {

        fun setItemViews(items: List<Item>)

        fun startItemDetailActivity(item: Item)
    }

    interface Presenter : BasePresenter<View> {

        fun getContentList(title: String)

        fun onItemSelected(id: Int)
    }
}
