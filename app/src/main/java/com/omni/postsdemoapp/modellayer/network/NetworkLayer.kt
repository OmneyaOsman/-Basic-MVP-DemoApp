package com.omni.postsdemoapp.modellayer.network

import com.omni.postsdemoapp.modellayer.entities.Message
import io.reactivex.Single

/**
 *created by Omni on 25/01/2019
 */

class NetworkLayer{

    companion object { val instance = NetworkLayer() }

    private val apiService: ApiService

    init {
        apiService = ServiceGenerator.createService(ApiService::class.java)
    }

    //region End Point

   internal fun getMessage(articleId: String): Single<Message> {
        return apiService.getMessageRx(articleId)
    }

   internal fun getMessages(): Single<List<Message>> {
        return apiService.getMessagesRx()
    }

    //endregion
}