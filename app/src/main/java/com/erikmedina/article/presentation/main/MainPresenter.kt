package com.erikmedina.article.presentation.main

import com.erikmedina.article.data.local.model.ItemView
import com.erikmedina.article.domain.interactor.GetContentListInteractor
import javax.inject.Inject

class MainPresenter
@Inject
constructor() : MainContract.Presenter {

    @Inject
    lateinit var interactor: GetContentListInteractor

    private var view: MainContract.View? = null

    override fun takeView(view: MainContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

    override fun getContentList() {
        interactor.run(object : GetContentListInteractor.Callback {
            override fun onSuccess(itemViews: List<ItemView>) {
                view?.setItemViews(itemViews)
            }

            override fun onError(throwable: Throwable) {
                //If we create an ErrorManager, depends of the type of error we can show different messages to
                //the user. Now we show the same message.
                // Also if we inject a context, we can retrieve string resources and avoid text hardcoding
                view?.showError("There was a problem. Try later")
            }
        })
    }

    companion object {
        val TAG = MainPresenter::class.java.simpleName
    }
}
