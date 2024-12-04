package com.insearching.megaverse.app.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.insearching.megaverse.R
import com.insearching.megaverse.ui.theme.MageverseTheme

@Composable
fun MegaverseScreen(
    modifier: Modifier = Modifier,
    state: MegaverseState,
    onAction: (MegaverseAction) -> Unit,
) {
    if (state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onAction(MegaverseAction.onMegaverseCreated)
                    }
                ) {
                    Text(stringResource(R.string.create_megaverse))
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onAction(MegaverseAction.onMegaverseDestroyed)
                    }
                ) {
                    Text(stringResource(R.string.destroy_megaverse))
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun CoinListScreenPreview() {
    MageverseTheme {
        MegaverseScreen(
            modifier = Modifier.fillMaxSize(),
            state = MegaverseState(),
            onAction = {}
        )
    }
}