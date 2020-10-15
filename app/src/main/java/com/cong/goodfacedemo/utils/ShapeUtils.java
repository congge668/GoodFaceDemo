package com.cong.goodfacedemo.utils;

import android.graphics.drawable.GradientDrawable;
import android.view.View;

import static android.graphics.drawable.GradientDrawable.LINEAR_GRADIENT;
import static android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT;
import static android.graphics.drawable.GradientDrawable.Orientation.TL_BR;
import static android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM;

/**
 * @author ：congge
 * @date : 2019/6/10 10:50
 * @desc :shape工具类
 *
 **/
public class ShapeUtils {

    /**
     * 设置 shape 的颜色
     * @param view
     * @param solidColor
     */
    public static void setShapeColor(View view, int solidColor){
        if(view == null){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(solidColor);
        view.setBackground(gradientDrawable);
    }

    /**
     * 设置shape倒角
     * @param view
     * @param corner
     */
    public static void setShapeCorner2Color(View view, float corner){
        if(view == null){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(corner);
        view.setBackground(gradientDrawable);
    }

    /**
     * 设置shape倒角和颜色
     * @param view
     * @param solidColor
     * @param corner
     */
    public static void setShapeCorner2Color(View view, int solidColor, float corner){
        if(view == null){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(solidColor);
        gradientDrawable.setCornerRadius(corner);
        view.setBackground(gradientDrawable);
    }

    /**
     * 设置shape倒角 颜色 和描边颜色和大小
     * @param view
     * @param solidColor
     * @param corner
     */
    public static void setShapeCorner2Color2Stroke(View view, int solidColor, float corner, int strokeColor, int strokeWidth){
        if(view == null){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(solidColor);
        gradientDrawable.setCornerRadius(corner);
        gradientDrawable.setStroke(strokeWidth, strokeColor);
        view.setBackground(gradientDrawable);
    }

    /**
     * 设置矩形渐变，同时shape渐变类型只能是线性从上倒下，颜色数组中的顺序即是渐变顺序
     * @param view
     * @param colors
     */
    public static void setShapeGradient(View view, int[] colors){
        if(view == null){
            return;
        }
        if(colors.length > 3){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(LINEAR_GRADIENT);
        gradientDrawable.setColors(colors);
        view.setBackground(gradientDrawable);
    }

    /**
     * 设置矩形渐变
     * @param view
     * @param colors
     * @param gradientType 渐变类型
     */
    public static void setShapeGradient(View view, int[] colors, int gradientType){
        if(view == null){
            return;
        }
        if(colors.length > 3){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(gradientType);
        gradientDrawable.setColors(colors);
        view.setBackground(gradientDrawable);
    }

    /**
     * 设置圆角渐变，同时shape渐变类型只能是线性从左倒右，颜色数组中的顺序即是渐变顺序
     * @param view
     * @param colors
     */
    public static void setShapeGradientAndRound(View view, int[] colors, float corner){
        if(view == null){
            return;
        }
        if(colors.length > 3){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        // 设置颜色渐变方向
        gradientDrawable.setOrientation(LEFT_RIGHT);
        gradientDrawable.setColors(colors);
        gradientDrawable.setCornerRadius(corner);
        view.setBackground(gradientDrawable);
    }

    public static void setShapeGradientTopToBottomAndRound(View view, int[] colors, float corner){
        if(view == null){
            return;
        }
        if(colors.length > 3){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        // 设置颜色渐变方向
        gradientDrawable.setOrientation(TOP_BOTTOM);
        gradientDrawable.setColors(colors);
        gradientDrawable.setCornerRadius(corner);
        view.setBackground(gradientDrawable);
    }

    public static void setShapeGradientTopLToBottomR(View view, int[] colors){
        if(view == null){
            return;
        }
        if(colors.length > 3){
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        // 设置颜色渐变方向
        gradientDrawable.setOrientation(TL_BR);
        gradientDrawable.setColors(colors);

        view.setBackground(gradientDrawable);
    }

    /**
     * desc: 设置圆角加带描边
    **/
    public static void setShapeRoundAndEdge(View view, int lineWide, int lineColor, int solidColor, float corner){
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(lineWide,lineColor);
        if(solidColor != 0){
            gradientDrawable.setColor(solidColor);
        }
        gradientDrawable.setCornerRadius(corner);
        view.setBackground(gradientDrawable);
    }

    /**
     * desc: 分别设置四个圆角加带描边
     **/
    public static void setShapeRoundAndEdge(View view, int lineWide, int lineColor, int solidColor, float[] corner){
        GradientDrawable gradientDrawable = new GradientDrawable();
        if(lineWide != 0 && lineColor != 0){
            gradientDrawable.setStroke(lineWide,lineColor);
        }
        if(solidColor != 0){
            gradientDrawable.setColor(solidColor);
        }
        gradientDrawable.setCornerRadii(corner);
        view.setBackground(gradientDrawable);
    }
}
