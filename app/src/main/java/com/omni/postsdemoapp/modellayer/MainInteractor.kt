package com.omni.postsdemoapp.modellayer

import com.omni.postsdemoapp.modellayer.entities.Message
import com.omni.postsdemoapp.modellayer.network.NetworkLayer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 *created by Omni on 27/01/2019
 */
class MainInteractor {

    companion object {
        val instance = MainInteractor()
    }

    private val networkLayer = NetworkLayer.instance
    private val bag = CompositeDisposable()

    interface OnFinishedListener {
        fun onResultSuccess(arrUpdates: List<Message>)
        fun onResultFail(strError: String)
    }


    //    }
    fun requestGetDataAPI(onFinishedListener: OnFinishedListener) {
        // Get data from server
        networkLayer.getMessages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribeWith(object :DisposableSingleObserver<List<Message>>() {
                    override fun onSuccess(list: List<Message>) {
                        if ( !list.isEmpty()) {
                            onFinishedListener.onResultSuccess(list)
                        } else {
                            onFinishedListener.onResultFail("Nothing to show")
                        }
                    }

                    override fun onError(e: Throwable) {
                        onFinishedListener.onResultFail("Something went wrong${e.message}")
                    }

                })?.let { bag.add(it) }
    }
}