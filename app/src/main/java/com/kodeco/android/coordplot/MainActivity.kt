package com.kodeco.android.coordplot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                PlotSurface()
            }
        }
    }
}

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
            val boxSize = 300
            val innerBoxSize = 20
            val xOffset = 10
            val yOffset = 10

            Map(xPercentage, yPercentage, modifier = Modifier.size(boxSize.dp)
                .background(Color.LightGray)
                .offset((xPercentage * boxSize - xOffset).dp, (yPercentage * boxSize - yOffset).dp),
                innerBoxSize)

            Slider(
                value = xPercentage,
                onValueChange = { xPercentage = it }
            )

            Slider(
                value = yPercentage,
                onValueChange = { yPercentage = it }
            )
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

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier, innerBoxSize: Int) {
    Box(modifier = modifier)
        {
            Box(Modifier
                .size(innerBoxSize.dp)
                .clip(shape = CircleShape)
                .background(Color.Red)
            )
        }
}


