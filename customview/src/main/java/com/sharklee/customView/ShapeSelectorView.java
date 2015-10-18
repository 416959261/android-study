package com.sharklee.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2015/10/18.
 */
public class ShapeSelectorView extends View {

    private int shapeColor;
    private boolean displayShapeName;

    private int shapeWidth = 100;
    private int shapeHeight = 100;
    private int textXOffset = 0;
    private int textYOffset = 30;

    private String[] shapes = new String[]{"Square","Circle","triangle"};
    private int currentShapeIndex = 0;

    private Paint mPaint;

    public ShapeSelectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupAttrs(context, attrs);
        setupPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(shapes[currentShapeIndex].equals("Square")){
            canvas.drawRect(0,0,shapeWidth,shapeHeight,mPaint);
            textXOffset = 0;
        }else if(shapes[currentShapeIndex].equals("Circle")){
            canvas.drawCircle(shapeWidth/2,shapeHeight/2,shapeWidth/2,mPaint);
            textXOffset = 12;
        }else{
            canvas.drawPath(getTrianglePath(),mPaint);
            textXOffset = 0;
        }
        if(displayShapeName){
            canvas.drawText(shapes[currentShapeIndex],textXOffset,shapeHeight+textYOffset,mPaint);
        }
    }

    public Path getTrianglePath(){
        Point point1 = new Point(0,shapeHeight);
        Point point2 = new Point(shapeWidth/2,0);
        Point point3 = new Point(shapeWidth,shapeHeight);
        Path path = new Path();
        path.moveTo(point1.x,point1.y);
        path.lineTo(point2.x,point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int textPadding = 10;
        int ninW = shapeWidth + getPaddingLeft() + getPaddingRight();
        int ninH = shapeHeight + getPaddingTop() + getPaddingBottom();
        if(displayShapeName){
            ninH+=textPadding + textYOffset;
        }
        int w = resolveSizeAndState(ninW,widthMeasureSpec,0);
        int h = resolveSizeAndState(ninH,heightMeasureSpec,0);
        setMeasuredDimension(w,h);
    }

    private void setupAttrs(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeSelectorView);
        try {
            shapeColor = typedArray.getColor(R.styleable.ShapeSelectorView_shapeColor, Color.BLACK);
            displayShapeName = typedArray.getBoolean(R.styleable.ShapeSelectorView_displayShapeName,true);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                currentShapeIndex++;
                currentShapeIndex = currentShapeIndex%shapes.length;
//                postInvalidate();
                invalidate();
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle state = new Bundle();
        state.putParcelable("instanceState",super.onSaveInstanceState());
        state.putInt("currentShapeIndex",currentShapeIndex);
        return state;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if(state instanceof  Bundle){
            Bundle bundle = (Bundle) state;
            currentShapeIndex = bundle.getInt("currentShapeIndex");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
        }else{
            return;
        }
    }

    private void setupPaint(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(shapeColor);
        mPaint.setTextSize(30);
    }

    public boolean isDisplayShapeName() {
        return displayShapeName;
    }

    public void setDisplayShapeName(boolean displayShapeName) {
        this.displayShapeName = displayShapeName;
        invalidate();
        requestLayout();
    }

    public int getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(int shapeColor) {
        this.shapeColor = shapeColor;
        invalidate();
        requestLayout();
    }
}
