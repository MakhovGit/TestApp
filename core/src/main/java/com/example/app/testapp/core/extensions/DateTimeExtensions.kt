@file:JvmName("DateTimeExtensions")

package com.example.app.testapp.core.extensions

import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter

private const val DEFAULT_DATE_PATTERN = "yyyy-MM-dd"

fun String.toMillisFromDateUtc(pattern: String = DEFAULT_DATE_PATTERN): Long {
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    val localDate = LocalDate.parse(this, dateFormatter)
    return localDate.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()
}

fun String.toMillisFromDateLocal(pattern: String = DEFAULT_DATE_PATTERN): Long {
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    val localDate = LocalDate.parse(this, dateFormatter)
    return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
}

fun Long.toDateStringUtc(pattern: String = DEFAULT_DATE_PATTERN): String {
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    val instant = Instant.ofEpochMilli(this)
    val date = instant.atZone(ZoneOffset.UTC).toLocalDate()
    return date.format(dateFormatter)
}

fun Long.toDateStringLocal(pattern: String = DEFAULT_DATE_PATTERN): String {
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    val instant = Instant.ofEpochMilli(this)
    val date = instant.atZone(ZoneId.systemDefault()).toLocalDate()
    return date.format(dateFormatter)
}

