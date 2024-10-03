package com.sebasgrdev.intercamandroid.utils

import java.util.Calendar
import java.util.Locale

object DateUtils {
    fun getFormattedDate(): String {
        val calendar = Calendar.getInstance()
        val mexicanSpanishLocale = Locale("es", "MX")
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, mexicanSpanishLocale)
        val year = calendar.get(Calendar.YEAR)
        return "$dayOfMonth de $month de $year"
    }
}