package com.insearching.megaverse.app.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.insearching.megaverse.BuildConfig
import com.insearching.megaverse.app.data.mapper.toAstralObjectDto
import com.insearching.megaverse.app.data.networking.dto.AstralBodyDto
import com.insearching.megaverse.app.data.networking.dto.AstralObjectDto
import com.insearching.megaverse.app.domain.MegaverseMap
import com.insearching.megaverse.core.domain.MegaverseDataSource
import com.insearching.megaverse.core.domain.util.NetworkError
import com.insearching.megaverse.core.domain.util.isError
import com.insearching.megaverse.core.domain.util.map
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MegaverseDestructionWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams), KoinComponent {

    private val megaverseDataSource: MegaverseDataSource by inject()

    override suspend fun doWork(): Result {
        return loadMap()
    }

    private suspend fun loadMap(): Result {
        val result = megaverseDataSource
            .getMap(BuildConfig.CANDIDATE_ID)
            .map { map ->
                destroyMegaverse(map)
            }
        return if (result.isError) Result.failure() else Result.success()
    }

    private suspend fun destroyMegaverse(map: MegaverseMap): Result {
        map.astralObjects.forEachIndexed loop@{ rowIndex, row ->
            row.forEachIndexed { columnIndex, solarObject ->

                when (solarObject.toAstralObjectDto()) {
                    is AstralObjectDto.Polyanet -> {
                        val res = deletePolyanet(rowIndex, columnIndex)
                        if (res.isError) {
                            return Result.failure()
                        }
                    }

                    is AstralObjectDto.Soloon -> {
                        val res = deleteSoloon(rowIndex, columnIndex)
                        if (res.isError) {
                            return Result.failure()
                        }
                    }

                    is AstralObjectDto.Cometh -> {
                        val res = deleteCometh(rowIndex, columnIndex)
                        if (res.isError) {
                            return Result.failure()
                        }
                    }

                    else -> {
                        // do nothing
                    }
                }
            }
        }
        return Result.success()
    }

    private suspend fun deletePolyanet(
        rowIndex: Int,
        columnIndex: Int
    ): com.insearching.megaverse.core.domain.util.Result<Unit, NetworkError> {
        val body = AstralBodyDto(
            row = rowIndex,
            column = columnIndex,
            candidateId = BuildConfig.CANDIDATE_ID
        )
        return megaverseDataSource.deletePolyanet(body)
    }


    private suspend fun deleteSoloon(
        rowIndex: Int,
        columnIndex: Int
    ): com.insearching.megaverse.core.domain.util.Result<Unit, NetworkError> {
        val body = AstralBodyDto(
            row = rowIndex,
            column = columnIndex,
            candidateId = BuildConfig.CANDIDATE_ID
        )
        return megaverseDataSource.deleteSoloon(body)
    }

    private suspend fun deleteCometh(
        rowIndex: Int,
        columnIndex: Int,
    ): com.insearching.megaverse.core.domain.util.Result<Unit, NetworkError> {
        val body = AstralBodyDto(
            row = rowIndex,
            column = columnIndex,
            candidateId = BuildConfig.CANDIDATE_ID
        )
        return megaverseDataSource.deleteSoloon(body)
    }
}