package com.insearching.megaverse.app.presentation

sealed interface MegaverseAction {
    data object onMegaverseCreated: MegaverseAction
    data object onMegaverseDestroyed: MegaverseAction
}
