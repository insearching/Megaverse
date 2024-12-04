package com.insearching.megaverse.app.data.networking.dto

sealed class AstralObjectDto {
    data object Polyanet: AstralObjectDto()
    data class Cometh(val direction: Direction): AstralObjectDto()
    data class Soloon(val color: Color): AstralObjectDto()
}

enum class Direction(val value: String)  {
    Up("up"),
    Down("down"),
    Left("left"),
    Right("right")
}

enum class Color(val value: String) {
    Blue("blue"),
    White("white"),
    Purple("purple"),
    Red("red")
}