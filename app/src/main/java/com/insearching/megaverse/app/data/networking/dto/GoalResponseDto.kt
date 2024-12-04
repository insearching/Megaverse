package com.insearching.megaverse.app.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class GoalResponseDto(
    val goal: List<List<String>>
)