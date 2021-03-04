package com.bangtiray.mylibrary.data.source.remote.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
class BuiltByDto : Serializable {
    @SerializedName("href")
    var href: String? = null

    @SerializedName("avatar")
    var avatar: String? = null

    @SerializedName("username")
    var username: String? = null

    override fun toString(): String {
        return "BuiltByDto{" +
                "href = '" + href + '\'' +
                ",avatar = '" + avatar + '\'' +
                ",username = '" + username + '\'' +
                "}"
    }
}