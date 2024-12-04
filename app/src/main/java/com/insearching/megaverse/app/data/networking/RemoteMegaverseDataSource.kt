package com.insearching.megaverse.app.data.networking

import com.insearching.megaverse.app.data.mapper.toGoalResponse
import com.insearching.megaverse.app.data.networking.dto.AstralBodyDto
import com.insearching.megaverse.app.data.networking.dto.ComethAstralBodyDto
import com.insearching.megaverse.app.data.networking.dto.GoalResponseDto
import com.insearching.megaverse.app.data.networking.dto.SoloonAstralBodyDto
import com.insearching.megaverse.app.domain.MegaverseMap
import com.insearching.megaverse.core.data.networking.constructUrl
import com.insearching.megaverse.core.data.networking.safeCall
import com.insearching.megaverse.core.domain.MegaverseDataSource
import com.insearching.megaverse.core.domain.util.NetworkError
import com.insearching.megaverse.core.domain.util.Result
import com.insearching.megaverse.core.domain.util.map
import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

class RemoteMegaverseDataSource(
    private val httpClient: HttpClient
) : MegaverseDataSource {

    override suspend fun getMap(candidateId: String): Result<MegaverseMap, NetworkError> {
        return safeCall<GoalResponseDto> {
            httpClient.get(
                urlString = constructUrl("map/$candidateId/goal")
            )
        }.map { it.toGoalResponse() }
    }

    override suspend fun addPolyanet(body: AstralBodyDto): Result<Unit, NetworkError> {
        return safeCall<Unit> {
            sendPostRequestWithRedirect(
                urlString = constructUrl("/polyanets"),
                requestBody = body
            )
        }
    }

    override suspend fun deletePolyanet(body: AstralBodyDto): Result<Unit, NetworkError> {
        return safeCall<Unit> {
            sendDeleteRequestWithRedirect(
                urlString = constructUrl("/polyanets"),
                requestBody = body
            )
        }
    }

    override suspend fun addSoloon(body: SoloonAstralBodyDto): Result<Unit, NetworkError> {
        return safeCall<Unit> {
            sendPostRequestWithRedirect(
                urlString = constructUrl("/soloons"),
                requestBody = body
            )
        }
    }

    override suspend fun deleteSoloon(body: AstralBodyDto): Result<Unit, NetworkError> {
        return safeCall<Unit> {
            sendDeleteRequestWithRedirect(
                urlString = constructUrl("/soloons"),
                requestBody = body
            )
        }
    }

    override suspend fun addCometh(body: ComethAstralBodyDto): Result<Unit, NetworkError> {
        return safeCall<Unit> {
            sendPostRequestWithRedirect(
                urlString = constructUrl("/comeths"),
                requestBody = body
            )
        }
    }

    override suspend fun deleteCometh(body: AstralBodyDto): Result<Unit, NetworkError> {
        return safeCall<Unit> {
            sendDeleteRequestWithRedirect(
                urlString = constructUrl("/comeths"),
                requestBody = body
            )
        }
    }

    private suspend fun sendPostRequestWithRedirect(
        urlString: String,
        headers: Map<String, String> = emptyMap(),
        requestBody: Any
    ): HttpResponse {
        var currentUrl = urlString

        while (true) {
            val response = httpClient.post(currentUrl) {
                headers.forEach { (key, value) ->
                    header(key, value)
                }
                setBody(requestBody)
            }

            return if (response.status == HttpStatusCode.PermanentRedirect) {
                currentUrl = response.headers["Location"]
                    ?: throw IllegalStateException("Redirect without Location header")
                continue
            } else {
                response // Return the response body as a string (or adjust the return type if needed)
            }
        }
    }

    private suspend fun sendDeleteRequestWithRedirect(
        urlString: String,
        headers: Map<String, String> = emptyMap(),
        requestBody: Any
    ): HttpResponse {
        var currentUrl = urlString

        while (true) {
            val response = httpClient.delete(currentUrl) {
                headers.forEach { (key, value) ->
                    header(key, value)
                }
                setBody(requestBody)
            }

            return if (response.status == HttpStatusCode.PermanentRedirect) {
                currentUrl = response.headers["Location"]
                    ?: throw IllegalStateException("Redirect without Location header")
                continue
            } else {
                response // Return the response body as a string (or adjust the return type if needed)
            }
        }
    }
}