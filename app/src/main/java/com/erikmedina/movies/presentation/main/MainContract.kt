package com.erikmedina.movies.presentation.main

import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.core.platform.BasePresenter
import com.erikmedina.movies.core.platform.BaseView

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

        fun onItemSelected(id: String)
    }
}
