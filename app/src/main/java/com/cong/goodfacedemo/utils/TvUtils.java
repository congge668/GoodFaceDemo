package com.cong.goodfacedemo.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author ：congge
 * @date : 2020-08-24 8:56
 * @desc : TextView的连接和改色等
 **/
public class TvUtils {
    /**
     * 主要用于拼接字体
     *
     * @param tv     字体内容
     * @param tvSize 字体大小
     * @param color  字体颜色
     */
    private static SpannableStringBuilder stringToSpannable(String tv, int tvSize, int color) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        ColorStateList Colors = ColorStateList.valueOf(color);
        sp.setSpan(new TextAppearanceSpan(null, 0, tvSize, Colors, null), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        return sp;
    }

    /**
     * @param tv     字体内容 可解析html颜色和大小的
     * @param tvSize 字体大小
     * @param color  字体颜色
     */
    private static SpannableStringBuilder stringToSpannable(Spanned tv, int tvSize, int color) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        ColorStateList Colors = ColorStateList.valueOf(color);
        sp.setSpan(new TextAppearanceSpan(null, 0, tvSize, Colors, null), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        return sp;
    }

    /**
     * 主要用于拼接字体(字体颜色、大小默认为textView颜色、大小)
     *
     * @param tv 字体内容
     */
    private static SpannableStringBuilder stringToSpannable(String tv) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        sp.setSpan(new TextAppearanceSpan(null, 0, 0, null, null), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        return sp;
    }

    /**
     * 主要用于拼接字体(字体颜色默认为textView颜色)
     *
     * @param tv     字体内容
     * @param tvSize 字体大小
     */
    private static SpannableStringBuilder stringToSpannableSize(String tv, int tvSize) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        sp.setSpan(new TextAppearanceSpan(null, 0, tvSize, null, null), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        return sp;
    }

    /**
    * desc:加粗且改大小
    * Created by congge on 2019/4/26 14:43
    **/
    private static SpannableStringBuilder stringToSpannableSizeAndBold(String tv, int tvSize) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        sp.setSpan(new TextAppearanceSpan(null, 0, tvSize, null, null), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        sp.setSpan(new StyleSpan(Typeface.BOLD), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
    }

    /**
     * desc:加粗且改大小
     * Created by congge on 2019/4/26 14:43
     **/
    private static SpannableStringBuilder stringToSpannableSizeColorAndBold(String tv, int tvSize, int color) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        sp.setSpan(new TextAppearanceSpan(null, 0, tvSize, ColorStateList.valueOf(color), null), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        sp.setSpan(new StyleSpan(Typeface.BOLD), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
    }

    /**
     * 主要用于拼接字体(字体大小默认为textView大小)
     *
     * @param tv    字体内容
     * @param color 字体颜色
     */
    private static SpannableStringBuilder stringToSpannableColor(String tv, int color) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        ColorStateList Colors = ColorStateList.valueOf(color);
        sp.setSpan(new TextAppearanceSpan(null, 0, 0, Colors, null), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        return sp;
    }

    /**
     * 主要用于拼接字体(根据接口返回处理颜色)
     *
     * @param tv     字体内容
     * @param tvSize 字体大小
     */
    private static SpannableStringBuilder stringToSpannableSize(Spanned tv, int tvSize) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        sp.setSpan(new TextAppearanceSpan(null, 0, tvSize, null, null), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        return sp;
    }

    /**
     * 主要用于拼接字体
     * 带加粗
     *
     * @param tv    字体内容
     * @param color 字体颜色
     */
    private static SpannableStringBuilder stringToSpannableBold(String tv, int color) {
        final SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        sp.setSpan(new ForegroundColorSpan(color), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        sp.setSpan(new StyleSpan(Typeface.BOLD), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
    }

    /**
     * desc:删除线，字体颜色
     * Created by congge on 2018/8/27 15:29
     **/
    private static SpannableStringBuilder strikeSpannable(String tv, int color) {
        SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        sp.setSpan(new StrikethroughSpan(), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(color), 0, tv.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
    }

    /**
     * desc:删除线，字体颜色
     * Created by congge on 2018/8/27 15:29
     **/
    private static SpannableStringBuilder strikeSpannable(String tv){
        SpannableStringBuilder sp = new SpannableStringBuilder(tv);
        sp.setSpan(new StrikethroughSpan(),0,tv.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return sp;
    }

    /**
     * TextView拼接部分字体颜色大小
     */
    public static StringToSpannable create() {
        return new StringToSpannable();
    }

    /**
     * TextView拼接部分字体颜色大小的类
     */
    public static class StringToSpannable {
        private SpannableStringBuilder ssb;

        /**
         * 只初始化一次
         */
        public StringToSpannable() {
            ssb = new SpannableStringBuilder();
        }

        public SpannableStringBuilder createSsb() {
            return new SpannableStringBuilder();
        }

        /**
         * 普通拼接
         *
         * @param tv
         */
        public StringToSpannable addSsb(String tv) {
            ssb.append(stringToSpannable(tv));
            return this;
        }

        /**
         * 改变大小颜色的拼接
         *
         * @param tv
         * @param size
         * @param color
         */
        public StringToSpannable addSsb(String tv, int size, int color) {

            ssb.append(stringToSpannable(tv, size, color));
            return this;
        }

        /**
         * 改变大小颜色的拼接
         *
         * @param tv
         * @param color
         */
        public StringToSpannable addSsbBold(String tv, int color) {
            ssb.append(stringToSpannableBold(tv, color));
            return this;
        }

        /**
         * 删除线拼接
         *
         * @param tv
         * @param color
         */
        public StringToSpannable addSsbStrike(String tv, int color) {
            ssb.append(strikeSpannable(tv, color));
            return this;
        }

        /**
         * 删除线拼接
         * @param tv
         *
         */
        public StringToSpannable addSsbStrike(String tv) {
            ssb.append(strikeSpannable(tv));
            return this;
        }

        /**
         * 改变大小颜色的拼接 （可解析html内容颜色和大小）
         *
         * @param tv
         * @param size
         * @param color
         */
        public StringToSpannable addSsb(Spanned tv, int size, int color) {
            ssb.append(stringToSpannable(tv, size, color));
            return this;
        }

        /**
         * 只改变大小的拼接
         *
         * @param tv
         * @param size
         */
        public StringToSpannable addSsbSize(String tv, int size) {
            ssb.append(stringToSpannableSize(tv, size));
            return this;
        }

        public StringToSpannable addSsbSizeAndBold(String tv, int size) {
            ssb.append(stringToSpannableSizeAndBold(tv, size));
            return this;
        }

        public StringToSpannable addSsbSizeColorAndBold(String tv, int size, int color) {
            ssb.append(stringToSpannableSizeColorAndBold(tv, size,color));
            return this;
        }

        /**
         * 只改变大小的拼接(接口返回需要修改颜色时)
         *
         * @param tv
         * @param size
         */
        public StringToSpannable addSsbSize(Spanned tv, int size) {
            ssb.append(stringToSpannableSize(tv, size));
            return this;
        }

        /**
         * 只改变颜色的拼接
         *
         * @param tv
         * @param color
         */
        public StringToSpannable addSsbColor(String tv, int color) {
            ssb.append(stringToSpannableColor(tv, color));
            return this;
        }

        /**
         * 单独改变" | "的颜色
         */
        public StringToSpannable addLine() {
            ssb.append(stringToSpannableColor(" | ", 0xffe1e1e1));
            return this;
        }

        /**
         * 可以点击部分文字
         *
         * @param addStr
         * @param color
         * @param clickListener
         */
        public StringToSpannable addSsbColorClick(String addStr, final int color, final View.OnClickListener clickListener) {
            SpannableString gotoStr = new SpannableString(addStr);
            gotoStr.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    clickListener.onClick(widget);
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setColor(color); //设置颜色
                    ds.setUnderlineText(false);
                }
            }, 0, gotoStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.append(gotoStr);
            return this;
        }

        /**
         * 显示控件上
         *
         * @param textView
         */
        public void showIn(TextView textView) {
            textView.setText(ssb);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            ssb = null;
        }

        /**
         * 显示控件上(hint提示)
         *
         * @param textView
         */
        public void showHintIn(TextView textView) {
            textView.setHint(ssb);
            ssb = null;
        }
    }


}
