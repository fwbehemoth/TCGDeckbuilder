package com.valerunners.tcgdeckbuilder.ui.compose.universal

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun createTextWithStroke(_text: String){
    // Create a Paint that has black stroke
    val textPaintStroke = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.STROKE
        textSize = 100f
        color = android.graphics.Color.BLACK
        strokeWidth = 12f
        strokeMiter= 10f
        strokeJoin = android.graphics.Paint.Join.ROUND
    }

    // Create a Paint that has white fill
    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.FILL
        textSize = 100f
        color = android.graphics.Color.WHITE
    }

    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    _text,
                    150f,
                    100.dp.toPx(),
                    textPaintStroke
                )

                it.nativeCanvas.drawText(
                    _text,
                    150f,
                    100.dp.toPx(),
                    textPaint
                )
            }
        }
    )
}