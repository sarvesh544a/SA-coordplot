package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PointerImage(innerBoxSize: Int) {
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.pointerbig),
        contentDescription = "",
        modifier = Modifier
            .size(innerBoxSize.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PointerImagePreview() {
    PointerImage(20)
}