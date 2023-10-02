package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircularProgressBarView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val circlePaint = Paint()
    private var progress = 0f

    init {
        circlePaint.color = Color.RED
        circlePaint.style = Paint.Style.STROKE
        circlePaint.strokeWidth = 20f
    }

    fun setProgress(newProgress: Float) {
        progress = newProgress
        invalidate() // Перерисовываем вид
    }

    override fun onDraw(canvas: Canvas) {
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (Math.min(centerX, centerY) - circlePaint.strokeWidth / 2f)

        canvas.drawCircle(centerX, centerY, radius, circlePaint)

        val sweepAngle = 360 * (progress / 100)
        canvas.drawArc(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius,
            -90f,
            sweepAngle,
            false,
            circlePaint
        )
    }
}
