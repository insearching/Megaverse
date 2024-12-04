package com.insearching.megaverse.app.domain

enum class AstralObject(private val value: String) {
    Space("SPACE"),
    Polyanet("POLYANET"),

    RightCometh("RIGHT_COMETH"),
    DownCometh("DOWN_COMETH"),
    UpCometh("UP_COMETH"),
    LeftCometh("LEFT_COMETH"),

    BlueSoloon("BLUE_SOLOON"),
    WhiteSoloon("WHITE_SOLOON"),
    PurpleSoloon("PURPLE_SOLOON"),
    RedSoloon("RED_SOLOON");

    companion object {
        fun fromKey(key: String): AstralObject? {
            return entries.firstOrNull { it.value == key }
        }
    }
}