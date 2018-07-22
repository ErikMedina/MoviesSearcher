package com.erikmedina.article.presentation.main

import com.erikmedina.article.data.local.model.ItemView
import com.erikmedina.article.presentation.BasePresenter
import com.erikmedina.article.presentation.BaseView

/**
 * This interface specifies the contract between the view and the presenter.
 */

interface MainContract {

    interface View : BaseView<Presenter> {

        fun setItemViews(itemViews: List<ItemView>)
    }

    interface Presenter : BasePresenter<View> {

        fun getItems()

        fun getContentList()
    }
}
