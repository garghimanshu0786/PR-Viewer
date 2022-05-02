package com.example.prviewer.model

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class PullRequest(
    @SerializedName("title")
    val title: String,

    @SerializedName("created_at")
    val createdDate: String,

    @SerializedName("closed_at")
    val closedDate: String?,

    val user: User
) {
    override fun toString(): String {
        return "Title: $title \nCreated Date: ${
            OffsetDateTime.parse(createdDate).format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))
        } ${
            closedDate?.let {
                "\nClosed Date: " + OffsetDateTime.parse(it)
                    .format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))
            }.run { "" }
        }\nUser Name: ${user.login}"
    }
}

class User(
    val login: String,

    @SerializedName("avatar_url")
    val imageUrl: String
)
