package com.omni.postsdemoapp.postsList

import android.util.Log
import com.omni.postsdemoapp.modellayer.MainInteractor
import com.omni.postsdemoapp.modellayer.entities.Message

/**
 *created by Omni on 25/01/2019
 */
class MainPresenterImp(private var mainView: MainView? ,private val mainInteractor: MainInteractor):MainInteractor.OnFinishedListener {

    init {
        mainView?.attachUI()

    }
    fun requestData(){
        mainView?.showProgress(true)
        mainInteractor.requestGetDataAPI(this)
    }

    override fun onResultSuccess(arrUpdates: List<Message>) {
        mainView?.showProgress(false)
        mainView?.loadDataSuccess(arrUpdates)
    }

    override fun onResultFail(strError: String) {
        Log.d("onResultFail" , strError)
        mainView?.showProgress(false)
        mainView?.showErrorMessage(strError)

    }

    fun onDestroy(){
        mainView = null
    }
}