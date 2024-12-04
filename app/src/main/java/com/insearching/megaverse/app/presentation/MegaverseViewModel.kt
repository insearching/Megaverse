package com.insearching.megaverse.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.insearching.megaverse.R
import com.insearching.megaverse.app.data.worker.MegaverseCreationWorker
import com.insearching.megaverse.app.data.worker.MegaverseDestructionWorker
import com.insearching.megaverse.core.presentation.UiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class MegaverseViewModel(
    private val workManager: WorkManager,
) : ViewModel() {

    private val _state = MutableStateFlow(MegaverseState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            MegaverseState()
        )

    private val _events = Channel<MegaverseEvent>()
    val events = _events.receiveAsFlow()

    fun onAction(action: MegaverseAction) {
        when (action) {
            MegaverseAction.onMegaverseCreated -> {
                createMegaverseBackground(UUID.randomUUID())
            }

            MegaverseAction.onMegaverseDestroyed -> {
                destroyMegaverseBackground(UUID.randomUUID())
            }
        }
    }

    private fun createMegaverseBackground(workRequestId: UUID) {
        val createMegaverse = OneTimeWorkRequestBuilder<MegaverseCreationWorker>().build()
        workManager.enqueue(createMegaverse)

        workManager.getWorkInfoByIdLiveData(workRequestId).observeForever { workInfo ->
            workInfo?.let {
                viewModelScope.launch {
                    when (it.state) {
                        WorkInfo.State.RUNNING -> {
                            _state.update { it.copy(isLoading = true) }
                        }
                        WorkInfo.State.SUCCEEDED -> {
                            _state.update { it.copy(isLoading = false) }
                            _events.send(MegaverseEvent.Toast(UiText.StringResource(R.string.megaverse_created)))
                        }

                        WorkInfo.State.FAILED -> {
                            _state.update { it.copy(isLoading = false) }
                            _events.send(MegaverseEvent.Toast(UiText.StringResource(R.string.error_unknown)))
                        }

                        else -> {
                            // do nothing
                        }
                    }
                }
            }
        }
    }

    private fun destroyMegaverseBackground(workRequestId: UUID) {
        val destroyMegaverse = OneTimeWorkRequestBuilder<MegaverseDestructionWorker>().build()
        workManager.enqueue(destroyMegaverse)

        workManager.getWorkInfoByIdLiveData(workRequestId).observeForever { workInfo ->
            workInfo?.let {
                viewModelScope.launch {
                    when (it.state) {
                        WorkInfo.State.RUNNING -> {
                            _state.update { it.copy(isLoading = true) }
                        }
                        WorkInfo.State.SUCCEEDED -> {
                            _state.update { it.copy(isLoading = false) }
                            _events.send(MegaverseEvent.Toast(UiText.StringResource(R.string.megaverse_destroyed)))
                        }

                        WorkInfo.State.FAILED -> {
                            _state.update { it.copy(isLoading = false) }
                            _events.send(MegaverseEvent.Toast(UiText.StringResource(R.string.error_unknown)))
                        }

                        else -> {
                            // do nothing
                        }
                    }
                }
            }
        }
    }
}