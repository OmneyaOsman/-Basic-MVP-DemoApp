package com.omni.postsdemoapp.modellayer.network

import com.omni.postsdemoapp.modellayer.entities.Message
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *created by Omni on 23/01/2019
 */

//todo annotated as Singlton
interface ApiService {

    @GET("/posts")
    fun getMessagesRx(): Single<List<Message>>

    @GET("/posts/{articleId}")
    fun getMessageRx(@Path("articleId") articleId: String): Single<Message>
}