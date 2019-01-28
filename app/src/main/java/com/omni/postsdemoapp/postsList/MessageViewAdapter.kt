package com.jonbott.learningrxjava.Activities.NetworkExample.Recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omni.postsdemoapp.R
import com.omni.postsdemoapp.modellayer.entities.Message
import com.omni.postsdemoapp.postsList.MessageViewHolder

//class MessageViewAdapter(val messages :mutableListOf()
////        var onItemClicked: ItemClickedlambda
//): RecyclerView.Adapter<MessageViewHolder>() {

class MessageViewAdapter : RecyclerView.Adapter<MessageViewHolder>() {

    internal val messages = mutableListOf<Message>()

    fun setMessages(list: List<Message>) {
        if (messages.isNotEmpty())
            messages.clear()
        messages.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        val viewHolder = MessageViewHolder(view)

//        view.setOnClickListener { v -> onItemClicked(v, viewHolder.adapterPosition) }

        return viewHolder
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.configureWith(message)
    }

    override fun getItemCount(): Int = messages.count() ?: 0

}