package com.insearching.megaverse.core.domain

import com.insearching.megaverse.app.data.networking.dto.AstralBodyDto
import com.insearching.megaverse.app.data.networking.dto.ComethAstralBodyDto
import com.insearching.megaverse.app.data.networking.dto.SoloonAstralBodyDto
import com.insearching.megaverse.app.domain.MegaverseMap
import com.insearching.megaverse.core.domain.util.NetworkError
import com.insearching.megaverse.core.domain.util.Result

interface MegaverseDataSource {
    suspend fun getMap(candidateId: String): Result<MegaverseMap, NetworkError>
    suspend fun addPolyanet(body: AstralBodyDto): Result<Unit, NetworkError>
    suspend fun deletePolyanet(body: AstralBodyDto): Result<Unit, NetworkError>
    suspend fun addSoloon(body: SoloonAstralBodyDto): Result<Unit, NetworkError>
    suspend fun deleteSoloon(body: AstralBodyDto): Result<Unit, NetworkError>
    suspend fun addCometh(body: ComethAstralBodyDto): Result<Unit, NetworkError>
    suspend fun deleteCometh(body: AstralBodyDto): Result<Unit, NetworkError>
}