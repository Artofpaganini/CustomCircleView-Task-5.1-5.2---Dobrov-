package by.andresen.intern.dobrov.mycustomcircleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;

public class CustomCircleView extends View {

    private static final String TAG = "CustomCircleView";

    private static final int DEFAULT_CIRCLE_SIZE = 100;
    private float circleDiameter;
    private Paint paint;
    float radius;
    float w;
    float h;
    float cx;
    float cy;

    public CustomCircleView(Context context) {
        super(context);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);

        if (attributeSet == null) {
            return;
        }

        TypedArray typedArray = getContext()
                .obtainStyledAttributes(attributeSet, R.styleable.CustomCircleView);

        try {
            circleDiameter = typedArray.getDimensionPixelSize(R.styleable.CustomCircleView_circleRadius, DEFAULT_CIRCLE_SIZE);
            Log.d(TAG, "init: GET DIAMETER " + circleDiameter + " FOR CIRCLE");

        } finally {
            typedArray.recycle();

        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        w = getWidth();
        h = getHeight();
        cx = w / 2;
        cy = h / 2;

        if (w > h) {
            radius = h / 4;
        } else {
            radius = w / 4;
        }

        Log.d(TAG, "onDraw: Radius " + h);

        paint.setColor(getResources().getColor(R.color.circle_background_color));
        canvas.drawCircle(cx, cy, radius, paint);

        Log.d(TAG, "onDraw: START TO DRAW THE CIRCLE");
        super.onDraw(canvas);
    }

}
