package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CounterView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var value: Int = 0
        set(newValue) {
            field = newValue
            cornerRadius = newValue.toFloat()
            invalidate()
        }


    private var cornerRadius: Float = 0f

    private val paint = Paint()

    private val rect = RectF()
    init {
        paint.color = Color.YELLOW
    }

    override fun onDraw(canvas: Canvas) {
        rect.set(0f, 0f, width.toFloat(), height.toFloat())
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint)
    }
}
