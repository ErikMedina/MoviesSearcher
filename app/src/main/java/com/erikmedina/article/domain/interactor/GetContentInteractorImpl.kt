package com.erikmedina.article.domain.interactor

import com.erikmedina.article.data.local.model.ItemView
import com.erikmedina.article.domain.repository.Repository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class GetContentInteractorImpl
@Inject
constructor(private val repository: Repository) : GetContentInteractor {

    private lateinit var callback: GetContentInteractor.Callback
    private var id = -1

    override fun run(id: Int, callback: GetContentInteractor.Callback) {
        this.callback = callback
        this.id = id
        execute()
    }

    override fun execute() {
        launch(UI) {
            repository.getContent(id, object : Repository.Callback<ItemView> {
                override fun onSuccess(item: ItemView) {
                    callback.onSuccess(item)
                }

                override fun onError(throwable: Throwable) {
                    callback.onError(throwable)
                }
            })
        }
    }
}
