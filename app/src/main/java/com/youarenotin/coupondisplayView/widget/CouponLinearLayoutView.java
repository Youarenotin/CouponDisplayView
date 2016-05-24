package com.youarenotin.coupondisplayView.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by youarenotin .
 */
public class CouponLinearLayoutView extends LinearLayout {
    private int circleNum;//圆的数量
    private Paint mPaint;//画笔
    private float d=50 ;//圆的直径
    private float gap=20; //圆与圆间距
    private float extra;//不整除后剩余的长度
    public CouponLinearLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CouponLinearLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        mPaint.setDither(true);//防抖动
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    public CouponLinearLayoutView(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        circleNum = (int) ((w-gap)/(d+gap));
       if (extra==0){
           extra=(w-gap)%(d+gap);
       }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0 ; i<circleNum ; i++){
            float centerX =extra/2+ gap+d/2+i*(d+gap);
            canvas.drawCircle(centerX,0,d/2,mPaint);
            canvas.drawCircle(centerX,getHeight(),d/2,mPaint);
        }
    }
}
