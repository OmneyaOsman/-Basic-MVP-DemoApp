package com.omni.postsdemoapp.modellayer.entities

data class Posting (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String )

data class Message (
        val id: Int,
        val body: String,
        val title: String,
        val userId: Int
)

data class Person (
    val firstName: String,
    val lastName: String,
    val age: Int)

data class Friend (
    val firstName: String,
    val lastName: String
){

    val description: String
        get() = "$firstName $lastName"
}