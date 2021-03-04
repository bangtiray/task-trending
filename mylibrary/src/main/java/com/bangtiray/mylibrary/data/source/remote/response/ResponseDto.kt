package com.bangtiray.mylibrary.data.source.remote.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
class ResponseDto : Serializable {
    @SerializedName("forks")
    var forks = 0

    @SerializedName("builtBy")
    var builtBy: List<BuiltByDto>? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("language")
    var language: String? = null

    @SerializedName("avatar")
    var avatar: String? = null

    @SerializedName("languageColor")
    var languageColor: String? = null

    @SerializedName("stars")
    var stars = 0

    @SerializedName("url")
    var url: String? = null

    @SerializedName("currentPeriodStars")
    var currentPeriodStars = 0

    override fun toString(): String {
        return "ResponseDto{" +
                "forks = '" + forks + '\'' +
                ",builtBy = '" + builtBy + '\'' +
                ",author = '" + author + '\'' +
                ",name = '" + name + '\'' +
                ",description = '" + description + '\'' +
                ",language = '" + language + '\'' +
                ",avatar = '" + avatar + '\'' +
                ",languageColor = '" + languageColor + '\'' +
                ",stars = '" + stars + '\'' +
                ",url = '" + url + '\'' +
                ",currentPeriodStars = '" + currentPeriodStars + '\'' +
                "}"
    }
}