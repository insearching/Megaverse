package com.insearching.megaverse.app.presentation

import com.insearching.megaverse.core.domain.util.NetworkError
import com.insearching.megaverse.core.presentation.UiText

sealed interface MegaverseEvent {
    data class Error(val error: NetworkError): MegaverseEvent
    data class Toast(val message: UiText): MegaverseEvent
}