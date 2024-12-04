package com.insearching.megaverse.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.insearching.cryptotracker.ui.theme.backgroundDark
import com.insearching.cryptotracker.ui.theme.backgroundDarkHighContrast
import com.insearching.cryptotracker.ui.theme.backgroundDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.backgroundLight
import com.insearching.cryptotracker.ui.theme.backgroundLightHighContrast
import com.insearching.cryptotracker.ui.theme.backgroundLightMediumContrast
import com.insearching.cryptotracker.ui.theme.errorContainerDark
import com.insearching.cryptotracker.ui.theme.errorContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.errorContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.errorContainerLight
import com.insearching.cryptotracker.ui.theme.errorContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.errorContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.errorDark
import com.insearching.cryptotracker.ui.theme.errorDarkHighContrast
import com.insearching.cryptotracker.ui.theme.errorDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.errorLight
import com.insearching.cryptotracker.ui.theme.errorLightHighContrast
import com.insearching.cryptotracker.ui.theme.errorLightMediumContrast
import com.insearching.cryptotracker.ui.theme.inverseOnSurfaceDark
import com.insearching.cryptotracker.ui.theme.inverseOnSurfaceDarkHighContrast
import com.insearching.cryptotracker.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.inverseOnSurfaceLight
import com.insearching.cryptotracker.ui.theme.inverseOnSurfaceLightHighContrast
import com.insearching.cryptotracker.ui.theme.inverseOnSurfaceLightMediumContrast
import com.insearching.cryptotracker.ui.theme.inversePrimaryDark
import com.insearching.cryptotracker.ui.theme.inversePrimaryDarkHighContrast
import com.insearching.cryptotracker.ui.theme.inversePrimaryDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.inversePrimaryLight
import com.insearching.cryptotracker.ui.theme.inversePrimaryLightHighContrast
import com.insearching.cryptotracker.ui.theme.inversePrimaryLightMediumContrast
import com.insearching.cryptotracker.ui.theme.inverseSurfaceDark
import com.insearching.cryptotracker.ui.theme.inverseSurfaceDarkHighContrast
import com.insearching.cryptotracker.ui.theme.inverseSurfaceDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.inverseSurfaceLight
import com.insearching.cryptotracker.ui.theme.inverseSurfaceLightHighContrast
import com.insearching.cryptotracker.ui.theme.inverseSurfaceLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onBackgroundDark
import com.insearching.cryptotracker.ui.theme.onBackgroundDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onBackgroundDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onBackgroundLight
import com.insearching.cryptotracker.ui.theme.onBackgroundLightHighContrast
import com.insearching.cryptotracker.ui.theme.onBackgroundLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onErrorContainerDark
import com.insearching.cryptotracker.ui.theme.onErrorContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onErrorContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onErrorContainerLight
import com.insearching.cryptotracker.ui.theme.onErrorContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.onErrorContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onErrorDark
import com.insearching.cryptotracker.ui.theme.onErrorDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onErrorDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onErrorLight
import com.insearching.cryptotracker.ui.theme.onErrorLightHighContrast
import com.insearching.cryptotracker.ui.theme.onErrorLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onPrimaryContainerDark
import com.insearching.cryptotracker.ui.theme.onPrimaryContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onPrimaryContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onPrimaryContainerLight
import com.insearching.cryptotracker.ui.theme.onPrimaryContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.onPrimaryContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onPrimaryDark
import com.insearching.cryptotracker.ui.theme.onPrimaryDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onPrimaryDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onPrimaryLight
import com.insearching.cryptotracker.ui.theme.onPrimaryLightHighContrast
import com.insearching.cryptotracker.ui.theme.onPrimaryLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onSecondaryContainerDark
import com.insearching.cryptotracker.ui.theme.onSecondaryContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onSecondaryContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onSecondaryContainerLight
import com.insearching.cryptotracker.ui.theme.onSecondaryContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.onSecondaryContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onSecondaryDark
import com.insearching.cryptotracker.ui.theme.onSecondaryDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onSecondaryDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onSecondaryLight
import com.insearching.cryptotracker.ui.theme.onSecondaryLightHighContrast
import com.insearching.cryptotracker.ui.theme.onSecondaryLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onSurfaceDark
import com.insearching.cryptotracker.ui.theme.onSurfaceDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onSurfaceDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onSurfaceLight
import com.insearching.cryptotracker.ui.theme.onSurfaceLightHighContrast
import com.insearching.cryptotracker.ui.theme.onSurfaceLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onSurfaceVariantDark
import com.insearching.cryptotracker.ui.theme.onSurfaceVariantDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onSurfaceVariantDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onSurfaceVariantLight
import com.insearching.cryptotracker.ui.theme.onSurfaceVariantLightHighContrast
import com.insearching.cryptotracker.ui.theme.onSurfaceVariantLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onTertiaryContainerDark
import com.insearching.cryptotracker.ui.theme.onTertiaryContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onTertiaryContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onTertiaryContainerLight
import com.insearching.cryptotracker.ui.theme.onTertiaryContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.onTertiaryContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.onTertiaryDark
import com.insearching.cryptotracker.ui.theme.onTertiaryDarkHighContrast
import com.insearching.cryptotracker.ui.theme.onTertiaryDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.onTertiaryLight
import com.insearching.cryptotracker.ui.theme.onTertiaryLightHighContrast
import com.insearching.cryptotracker.ui.theme.onTertiaryLightMediumContrast
import com.insearching.cryptotracker.ui.theme.outlineDark
import com.insearching.cryptotracker.ui.theme.outlineDarkHighContrast
import com.insearching.cryptotracker.ui.theme.outlineDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.outlineLight
import com.insearching.cryptotracker.ui.theme.outlineLightHighContrast
import com.insearching.cryptotracker.ui.theme.outlineLightMediumContrast
import com.insearching.cryptotracker.ui.theme.outlineVariantDark
import com.insearching.cryptotracker.ui.theme.outlineVariantDarkHighContrast
import com.insearching.cryptotracker.ui.theme.outlineVariantDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.outlineVariantLight
import com.insearching.cryptotracker.ui.theme.outlineVariantLightHighContrast
import com.insearching.cryptotracker.ui.theme.outlineVariantLightMediumContrast
import com.insearching.cryptotracker.ui.theme.primaryContainerDark
import com.insearching.cryptotracker.ui.theme.primaryContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.primaryContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.primaryContainerLight
import com.insearching.cryptotracker.ui.theme.primaryContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.primaryContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.primaryDark
import com.insearching.cryptotracker.ui.theme.primaryDarkHighContrast
import com.insearching.cryptotracker.ui.theme.primaryDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.primaryLight
import com.insearching.cryptotracker.ui.theme.primaryLightHighContrast
import com.insearching.cryptotracker.ui.theme.primaryLightMediumContrast
import com.insearching.cryptotracker.ui.theme.scrimDark
import com.insearching.cryptotracker.ui.theme.scrimDarkHighContrast
import com.insearching.cryptotracker.ui.theme.scrimDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.scrimLight
import com.insearching.cryptotracker.ui.theme.scrimLightHighContrast
import com.insearching.cryptotracker.ui.theme.scrimLightMediumContrast
import com.insearching.cryptotracker.ui.theme.secondaryContainerDark
import com.insearching.cryptotracker.ui.theme.secondaryContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.secondaryContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.secondaryContainerLight
import com.insearching.cryptotracker.ui.theme.secondaryContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.secondaryContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.secondaryDark
import com.insearching.cryptotracker.ui.theme.secondaryDarkHighContrast
import com.insearching.cryptotracker.ui.theme.secondaryDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.secondaryLight
import com.insearching.cryptotracker.ui.theme.secondaryLightHighContrast
import com.insearching.cryptotracker.ui.theme.secondaryLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceBrightDark
import com.insearching.cryptotracker.ui.theme.surfaceBrightDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceBrightDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceBrightLight
import com.insearching.cryptotracker.ui.theme.surfaceBrightLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceBrightLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerDark
import com.insearching.cryptotracker.ui.theme.surfaceContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighDark
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighLight
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighestDark
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighestDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighestLight
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighestLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerHighestLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLight
import com.insearching.cryptotracker.ui.theme.surfaceContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowDark
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowLight
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowestDark
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowestDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowestLight
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowestLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceContainerLowestLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceDark
import com.insearching.cryptotracker.ui.theme.surfaceDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceDimDark
import com.insearching.cryptotracker.ui.theme.surfaceDimDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceDimDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceDimLight
import com.insearching.cryptotracker.ui.theme.surfaceDimLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceDimLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceLight
import com.insearching.cryptotracker.ui.theme.surfaceLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceLightMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceVariantDark
import com.insearching.cryptotracker.ui.theme.surfaceVariantDarkHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceVariantDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.surfaceVariantLight
import com.insearching.cryptotracker.ui.theme.surfaceVariantLightHighContrast
import com.insearching.cryptotracker.ui.theme.surfaceVariantLightMediumContrast
import com.insearching.cryptotracker.ui.theme.tertiaryContainerDark
import com.insearching.cryptotracker.ui.theme.tertiaryContainerDarkHighContrast
import com.insearching.cryptotracker.ui.theme.tertiaryContainerDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.tertiaryContainerLight
import com.insearching.cryptotracker.ui.theme.tertiaryContainerLightHighContrast
import com.insearching.cryptotracker.ui.theme.tertiaryContainerLightMediumContrast
import com.insearching.cryptotracker.ui.theme.tertiaryDark
import com.insearching.cryptotracker.ui.theme.tertiaryDarkHighContrast
import com.insearching.cryptotracker.ui.theme.tertiaryDarkMediumContrast
import com.insearching.cryptotracker.ui.theme.tertiaryLight
import com.insearching.cryptotracker.ui.theme.tertiaryLightHighContrast
import com.insearching.cryptotracker.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Composable
fun MageverseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> highContrastDarkColorScheme
        else -> highContrastLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}