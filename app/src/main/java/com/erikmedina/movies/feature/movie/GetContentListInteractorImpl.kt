package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.data.local.model.Item
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class GetContentListInteractorImpl
@Inject
constructor(private val repository: Repository) : GetContentListInteractor {

    private var title = ""
    private lateinit var callback: GetContentListInteractor.Callback

    override fun run(title: String, callback: GetContentListInteractor.Callback) {
        this.title = title
        this.callback = callback
        execute()
    }

    override fun execute() {
        launch(UI) {
            repository.getContentList(title, object : Repository.Callback<List<Item>> {
                override fun onSuccess(items: List<Item>) {
                    callback.onSuccess(items)
                }

                override fun onError(throwable: Throwable) {
                    callback.onError(throwable)
                }
            })
        }
    }
}