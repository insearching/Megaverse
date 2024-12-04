package com.insearching.megaverse.app.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.insearching.megaverse.BuildConfig
import com.insearching.megaverse.app.data.mapper.toAstralObjectDto
import com.insearching.megaverse.app.data.networking.dto.AstralBodyDto
import com.insearching.megaverse.app.data.networking.dto.AstralObjectDto
import com.insearching.megaverse.app.data.networking.dto.Color
import com.insearching.megaverse.app.data.networking.dto.ComethAstralBodyDto
import com.insearching.megaverse.app.data.networking.dto.Direction
import com.insearching.megaverse.app.data.networking.dto.SoloonAstralBodyDto
import com.insearching.megaverse.app.domain.MegaverseMap
import com.insearching.megaverse.core.domain.MegaverseDataSource
import com.insearching.megaverse.core.domain.util.NetworkError
import com.insearching.megaverse.core.domain.util.isError
import com.insearching.megaverse.core.domain.util.map
import kotlinx.coroutines.delay
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.time.Duration.Companion.milliseconds

class MegaverseCreationWorker(
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
            .map { goal ->
                createMegaverse(goal)
            }
        return if (result.isError) Result.failure() else Result.success()
    }


    private suspend fun createMegaverse(map: MegaverseMap): Result {
        map.astralObjects.forEachIndexed loop@{ rowIndex, row ->
            row.forEachIndexed { columnIndex, solarObject ->
                when (val obj = solarObject.toAstralObjectDto()) {
                    is AstralObjectDto.Polyanet -> {
                        val res = createPolyanet(rowIndex, columnIndex)
                        if (res.isError) {
                            return Result.failure()
                        }
                    }

                    is AstralObjectDto.Soloon -> {
                        val res = createSoloon(
                            rowIndex,
                            columnIndex,
                            color = obj.color
                        )
                        if (res.isError) {
                            return Result.failure()
                        }
                    }

                    is AstralObjectDto.Cometh -> {
                        val res = createCometh(
                            rowIndex,
                            columnIndex,
                            obj.direction
                        )
                        if (res.isError) {
                            return Result.failure()
                        }
                    }

                    else -> {
                        // do nothing
                    }
                }
                // Added because API may throw too many request if sending to frequently :(.
                delay(200.milliseconds)
            }
        }
        return Result.success()
    }


    private suspend fun createPolyanet(
        rowIndex: Int,
        columnIndex: Int
    ): com.insearching.megaverse.core.domain.util.Result<Unit, NetworkError> {
        val body = AstralBodyDto(
            row = rowIndex,
            column = columnIndex,
            candidateId = BuildConfig.CANDIDATE_ID
        )

        return megaverseDataSource.addPolyanet(body)
    }

    private suspend fun createSoloon(
        rowIndex: Int,
        columnIndex: Int,
        color: Color
    ): com.insearching.megaverse.core.domain.util.Result<Unit, NetworkError> {
        val body = SoloonAstralBodyDto(
            row = rowIndex,
            column = columnIndex,
            color = color.value,
            candidateId = BuildConfig.CANDIDATE_ID,
        )

        return megaverseDataSource.addSoloon(body)
    }

    private suspend fun createCometh(
        rowIndex: Int,
        columnIndex: Int,
        direction: Direction
    ): com.insearching.megaverse.core.domain.util.Result<Unit, NetworkError> {
        val body = ComethAstralBodyDto(
            row = rowIndex,
            column = columnIndex,
            direction = direction.value,
            candidateId = BuildConfig.CANDIDATE_ID,
        )
        return megaverseDataSource.addCometh(body)
    }
}