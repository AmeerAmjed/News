package com.example.news.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun dateTimeFormat(date: String): String {
    val dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    val dateTime = ZonedDateTime.parse(date)
   return dateTime.withZoneSameInstant(ZoneId.of("UTC")).format(dateTimeFormatter)
}
