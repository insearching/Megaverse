package com.insearching.megaverse.app.data.mapper

import com.insearching.megaverse.app.data.networking.dto.AstralObjectDto
import com.insearching.megaverse.app.data.networking.dto.Color
import com.insearching.megaverse.app.data.networking.dto.Direction
import com.insearching.megaverse.app.data.networking.dto.GoalResponseDto
import com.insearching.megaverse.app.domain.AstralObject
import com.insearching.megaverse.app.domain.MegaverseMap

fun GoalResponseDto.toGoalResponse(): MegaverseMap {
    return MegaverseMap(
        this.goal.map { row ->
            row.map { column ->
                AstralObject.fromKey(column) ?: AstralObject.Space
            }
        }
    )
}

fun AstralObject.toAstralObjectDto(): AstralObjectDto? {
    return when (this) {
        AstralObject.Polyanet -> AstralObjectDto.Polyanet
        AstralObject.RightCometh -> AstralObjectDto.Cometh(Direction.Right)
        AstralObject.DownCometh -> AstralObjectDto.Cometh(Direction.Down)
        AstralObject.UpCometh -> AstralObjectDto.Cometh(Direction.Up)
        AstralObject.LeftCometh -> AstralObjectDto.Cometh(Direction.Left)
        AstralObject.BlueSoloon -> AstralObjectDto.Soloon(Color.Blue)
        AstralObject.WhiteSoloon -> AstralObjectDto.Soloon(Color.White)
        AstralObject.PurpleSoloon -> AstralObjectDto.Soloon(Color.Purple)
        AstralObject.RedSoloon -> AstralObjectDto.Soloon(Color.Red)
        else -> null
    }
}