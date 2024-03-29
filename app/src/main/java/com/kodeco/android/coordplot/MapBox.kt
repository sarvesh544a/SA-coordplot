package com.kodeco.android.coordplot

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MapBox(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current

    var boxSize = 300
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            boxSize = 280
        }
    }

    val innerBoxSize = 20
    val xOffset = 10
    val yOffset = 10
    Box(modifier = Modifier
        .size(boxSize.dp)
        .background(Color.DarkGray)
        .offset((xPercent * boxSize - xOffset).dp, ((1-yPercent) * boxSize - yOffset).dp))
    {
        PointerImage(innerBoxSize)
    }
}

@Preview(showBackground = true)
@Composable
fun MapBoxPreview() {
    MapBox(xPercent = 0.5f, yPercent = 0.5f)
}

