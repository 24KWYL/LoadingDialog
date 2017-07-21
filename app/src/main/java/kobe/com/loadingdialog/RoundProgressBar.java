package kobe.com.loadingdialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by KOBE on 2017/7/19.
 * 自定义进度条
 */

public class RoundProgressBar extends View {

    private Paint paint;//画笔
    private int roudColor;//圆环颜色
    private int rounddProgressColor;//进度条颜色
    private float roundWidth;//宽度
    private int max;//最大进度
    private int progress;//当前进度

    private int startAngle=-90;//起始角度
    private int endAngle=120;

    public RoundProgressBar(Context context) {
        super(context);
    }

    public RoundProgressBar(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public RoundProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
        TypedArray mTypedArray=context.obtainStyledAttributes(attrs,R.styleable.ProgressBar);
        //获取自定义属性和设置默认值
        roudColor=mTypedArray.getColor(R.styleable.ProgressBar_roundColor, Color.GRAY);
        rounddProgressColor=mTypedArray.getColor(R.styleable.ProgressBar_roundColor,Color.RED);
        roundWidth=mTypedArray.getDimension(R.styleable.ProgressBar_roundWidth,30);
        max=mTypedArray.getInteger(R.styleable.ProgressBar_max,80);
        mTypedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画外层圆形
        int center=getWidth()/2;//圆心坐标
        int radius= (int) (center-roundWidth);
        paint.setColor(roudColor);//设置颜色
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(roundWidth);//宽度
        paint.setAntiAlias(true);//消除锯齿
        canvas.drawCircle(center,center,radius,paint);//画圆
        //画进度
        paint.setColor(rounddProgressColor);
        RectF oval = new RectF(center - radius, center - radius, center
                + radius, center + radius);  //用于定义的圆弧的形状和大小的界限
        canvas.drawArc(oval,startAngle,endAngle,false,paint);
        startAngle+=5;
        if(startAngle>360){
            startAngle-=360;
        }
        invalidate();
    }
}
