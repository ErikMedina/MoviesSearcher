package com.erikmedina.article.domain.repository

import com.erikmedina.article.data.remote.service.ApiRest
import javax.inject.Singleton

/**
 * The repository will be responsible for transforming the data for the input and output of information.
 */
@Singleton
class RepositoryImpl constructor(private val apiRest: ApiRest) : Repository {

    override fun getContentList(callback: Repository.Callback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
