package com.example.managerfinansowy.data

import java.time.LocalDate
import java.util.*

data class ListItem(
    val shop: String,
    val category: String,
    val amount: Double,
    val date: LocalDate
)

