package com.insearching.megaverse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.insearching.megaverse.app.presentation.MegaverseEvent
import com.insearching.megaverse.app.presentation.MegaverseScreen
import com.insearching.megaverse.app.presentation.MegaverseViewModel
import com.insearching.megaverse.core.presentation.util.ObserveAsEvents
import com.insearching.megaverse.core.presentation.util.toString
import com.insearching.megaverse.ui.theme.MageverseTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val context = LocalContext.current
            val viewModel: MegaverseViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()

            ObserveAsEvents(events = viewModel.events) { event ->
                when (event) {
                    is MegaverseEvent.Error -> {
                        Toast.makeText(
                            context,
                            event.error.toString(context),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    is MegaverseEvent.Toast -> {
                        Toast.makeText(
                            context,
                            event.message.asString(context),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            MageverseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MegaverseScreen(
                        modifier = Modifier.padding(innerPadding),
                        state = state
                    ) { action ->
                        viewModel.onAction(action)
                    }
                }
            }
        }
    }
}
