package com.omni.postsdemoapp.postsList

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.omni.postsdemoapp.R
import com.omni.postsdemoapp.modellayer.entities.Message

class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val context = itemView.context
    val cardView: CardView
    val messageIdTextView: TextView
    val userIdTextView: TextView
    val titleTextView: TextView
    val bodyTextView: TextView

    init {
        cardView = itemView.findViewById(R.id.messageCardView)
        messageIdTextView = itemView.findViewById(R.id.messageIdTextView)
        userIdTextView = itemView.findViewById(R.id.userIdTextView)
        titleTextView = itemView.findViewById(R.id.titleTextView)
        bodyTextView = itemView.findViewById(R.id.bodyTextView)
    }

    fun configureWith(message: Message) {
        messageIdTextView.text = message.id.toString()
        userIdTextView.text = message.userId.toString()
        titleTextView.text = message.title
        bodyTextView.text = message.body
    }
}