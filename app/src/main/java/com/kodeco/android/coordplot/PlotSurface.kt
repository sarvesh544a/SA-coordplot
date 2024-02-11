package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun PlotSurface() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            var xPercentage: Float by remember { mutableFloatStateOf(0.5f) }
            var yPercentage: Float by remember { mutableFloatStateOf(0.5f) }

            MapBox(xPercentage, yPercentage, modifier = Modifier)

            MapSlider("X-Axis", percentage = xPercentage,
                onPercentageChange = { xPercentage = it })
            MapSlider("Y-Axis", percentage = yPercentage,
                onPercentageChange = { yPercentage = it })

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PlotSurfacePreview() {
    MyApplicationTheme {
        PlotSurface()
    }
}