package com.mom.app.retail.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomProgressBar extends View {
    // % value of the progressbar.
    int progressBarValue = 0;

    public CustomProgressBar(Context context) {
        super(context);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        progressBarValue = attrs.getAttributeIntValue(null, "progressBarValue", 0);
    }

    public void setValue(int value) {
        progressBarValue = value;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float cornerRadius = 30.0f;

        // Draw the background of the bar.
        Paint backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.parseColor("#f1f1ef"));
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setAntiAlias(true);

        RectF backgroundRect = new RectF(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.drawRoundRect(backgroundRect, cornerRadius, cornerRadius, backgroundPaint);

        // Draw the progress bar.
        Paint barPaint = new Paint();
        barPaint.setColor(Color.parseColor("#00d2d2"));
        barPaint.setStyle(Paint.Style.FILL);
        barPaint.setAntiAlias(true);

        float progress = (backgroundRect.width() / 100) * progressBarValue;
        RectF barRect = new RectF(0, 0, progress, canvas.getClipBounds().bottom);

        canvas.drawRoundRect(barRect, cornerRadius, cornerRadius, barPaint);

        // Draw progress text in the middle.
        Paint textPaint = new Paint();
        textPaint.setColor(Color.TRANSPARENT);
        textPaint.setTextSize(34);

        String text = progressBarValue + "%";
        Rect textBounds = new Rect();

        textPaint.getTextBounds(text, 0, text.length(), textBounds);

        canvas.drawText(text,
                backgroundRect.centerX() - (textBounds.width() / 2),
                backgroundRect.centerY() + (textBounds.height() / 2),
                textPaint);

    }
}
