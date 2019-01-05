package com.erikmedina.article.presentation.main

import com.erikmedina.article.data.local.model.Item
import com.erikmedina.article.domain.interactor.GetContentInteractor
import com.erikmedina.article.domain.interactor.GetContentListInteractor
import javax.inject.Inject

class MainPresenter
@Inject
constructor() : MainContract.Presenter {

    @Inject
    lateinit var contentListInteractor: GetContentListInteractor
    @Inject
    lateinit var contentInteractor: GetContentInteractor

    private var view: MainContract.View? = null

    override fun takeView(view: MainContract.View) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }

    override fun getContentList(title: String) {
        view?.showLoading(true)
        contentListInteractor.run(title, object : GetContentListInteractor.Callback {
            override fun onSuccess(items: List<Item>) {
                view?.setItemViews(items)
                view?.showLoading(false)
            }

            override fun onError(throwable: Throwable) {
                //If we create an ErrorManager, depends of the type of error we can show different messages to
                //the user. Now we show the same message.
                // Also if we inject a context, we can retrieve string resources and avoid text hardcoding
                view?.showError("There was a problem. Try later")
                view?.showLoading(false)
            }
        })
    }

    override fun onItemSelected(id: Int) {
        view?.showLoading(true)
        contentInteractor.run(id, object : GetContentInteractor.Callback {
            override fun onSuccess(item: Item) {
                view?.showLoading(false)
                view?.startItemDetailActivity(item)
            }

            override fun onError(throwable: Throwable) {
                view?.showError("There was a problem. Try later")
                view?.showLoading(false)
            }
        })
    }

    companion object {
        val TAG = MainPresenter::class.java.simpleName
    }
}
