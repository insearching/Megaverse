package com.insearching.megaverse.core.data.networking

import com.insearching.megaverse.BuildConfig.*

fun constructUrl(url: String): String {
    return when {
        url.contains(BASE_URL) -> url
        url.startsWith("/") -> BASE_URL + url.drop(1)
        else -> BASE_URL + url
    }
}