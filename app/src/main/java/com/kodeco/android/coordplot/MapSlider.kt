package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MapSlider(title: String, percentage: Float, onPercentageChange: (Float) -> Unit) {

    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title + " " + ((percentage) * 100).toInt() + "%",
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 8.dp).width(120.dp)
        )

        Slider(
            value = percentage,
            onValueChange = onPercentageChange
        )
    }
}

@Preview
@Composable
fun MapSliderPreview() {
    var xPercentage: Float
    MapSlider("X-Axis", 0.5f,
        onPercentageChange = { xPercentage = it })
}