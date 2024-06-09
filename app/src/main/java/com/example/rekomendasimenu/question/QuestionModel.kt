package com.example.rekomendasimenu.question

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionModel(
    @SerialName("kode_pertanyaan")
    var kodePertanyaan:String,
    @SerialName("pertanyaan")
    var pertanyaan:String="",
)

data class OptionModel(
    var answer:String = "",
    var value:Number = 0,
    var key:String = ""
)

data class PembeliModel(
    val id:String,
    val nama_pembeli:String
)
data class ResponseModel(
    val id_pembeli:Number,
    val kode_pertanyaan: String,
)
