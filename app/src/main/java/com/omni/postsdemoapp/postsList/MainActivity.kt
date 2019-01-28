package com.omni.postsdemoapp.postsList

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonbott.learningrxjava.Activities.NetworkExample.Recycler.MessageViewAdapter
import com.omni.postsdemoapp.R
import com.omni.postsdemoapp.modellayer.MainInteractor
import com.omni.postsdemoapp.modellayer.entities.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {


    private lateinit var presenter: MainPresenterImp
    private lateinit var adapter: MessageViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImp(this, MainInteractor.instance)
        presenter.requestData()
    }

    //region attach UI of View
    override fun attachUI() {
        val linearLayoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        messages_recycler_view?.layoutManager = linearLayoutManager
        messages_recycler_view?.setHasFixedSize(true)
        messages_recycler_view?.addItemDecoration(dividerItemDecoration)
        initializeView()
    }
    //endregion

    override fun showProgress(show: Boolean) {
        if (show)
            progress_bar?.visibility = View.VISIBLE
        else
            progress_bar?.visibility = View.GONE

    }
    override fun showErrorMessage(error: String) {
        empty_view?.text = error
    }

    //region load data from network
    override fun loadDataSuccess(list: List<Message>) {
        Log.d("here" ,list.toString())
        adapter.setMessages(list)
        messages_recycler_view?.adapter = adapter

    }

    //endregion

    //region setting the adapter to recyclerView
    override fun initializeView() {
        adapter = MessageViewAdapter()
//        { view, position -> rowTapped(position) }
    }
    //endregion


    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()

    }
}
