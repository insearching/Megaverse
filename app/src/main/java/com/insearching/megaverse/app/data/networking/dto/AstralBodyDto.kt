package com.insearching.megaverse.app.data.networking.dto

import kotlinx.serialization.Serializable


@Serializable
data class AstralBodyDto(
    val row: Int,
    val column: Int,
    val candidateId: String,
)

@Serializable
data class ComethAstralBodyDto(
    val row: Int,
    val column: Int,
    val candidateId: String,
    val direction: String
)

@Serializable
data class SoloonAstralBodyDto(
    val row: Int,
    val column: Int,
    val candidateId: String,
    val color: String
)