package com.sebasgrdev.intercamandroid.model.data

data class Payment(
    val operation_type: String,
    val total_operation: Int,
    val total_operation_auth: Int
)
