package ru.zavedyaev.billsplitterserver

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

val mapper: ObjectMapper = jacksonObjectMapper()
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)

data class Calculation(
        val id: String,
        val data: CalculationData
) {
    constructor(id: String, dataJson: String): this(id, mapper.readValue(dataJson, CalculationData::class.java))
    fun getDataJson(): String = mapper.writeValueAsString(data)
}

data class CalculationData(
    val previousId: String?,
    val people: List<Man>,
    val families: List<Family>,
    val spendings: List<Spending>
)

data class Man(
        val id: String,
        val name: String
)

data class Family(
    val id: String,
    val name: String,
    val members: List<String>
)

data class Spending(
        val id: String,
        val name: String?,
        val spent: Float,
        val payedBy: List<String>,
        val users: List<String>
)