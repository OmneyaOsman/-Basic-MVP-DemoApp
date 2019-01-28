package com.omni.postsdemoapp.postsList

import com.omni.postsdemoapp.modellayer.entities.Message

/**
 *created by Omni on 27/01/2019
 */
interface MainView {
    fun initializeView()
    fun attachUI()
    fun showProgress(show: Boolean)
    fun showErrorMessage(error: String)
    fun loadDataSuccess(list: List<Message>)
}