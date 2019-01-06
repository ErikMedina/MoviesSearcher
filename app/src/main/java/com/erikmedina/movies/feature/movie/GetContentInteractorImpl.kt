package com.erikmedina.movies.feature.movie

import com.erikmedina.movies.data.local.model.Item
import com.erikmedina.movies.core.util.Constant
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class GetContentInteractorImpl
@Inject
constructor(private val repository: Repository) : GetContentInteractor {

    private lateinit var callback: GetContentInteractor.Callback
    private var id = Constant.UNKNOWN

    override fun run(id: String, callback: GetContentInteractor.Callback) {
        this.callback = callback
        this.id = id
        execute()
    }

    override fun execute() {
        launch(UI) {
            repository.getContent(id, object : Repository.Callback<Item> {
                override fun onSuccess(item: Item) {
                    callback.onSuccess(item)
                }

                override fun onError(throwable: Throwable) {
                    callback.onError(throwable)
                }
            })
        }
    }
}
