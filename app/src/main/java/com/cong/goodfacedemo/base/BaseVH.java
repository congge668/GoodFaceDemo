package com.cong.goodfacedemo.base;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cong.goodfacedemo.utils.GlideUtils;


import java.math.BigDecimal;



public class BaseVH extends BaseViewHolder {

    private SparseArray<View> views;


    public BaseVH(View view) {
        super(view);
        this.views = new SparseArray<>();
    }


    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }


    /**
     * 通过strings.xml文件给TextView设置文本
     * <p>
     * 子控件的id
     *
     * @param viewId 子控件在strings.xml中的文本
     * @param resId  返回子控件
     * @return BaseVH
     */
    public BaseVH setText(@IdRes int viewId, @StringRes int resId) {
        if(getView(viewId) instanceof TextView){
            ((TextView) getView(viewId)).setText(resId);
        }
        return this;
    }



    /**
     * 通过String给TextView设置文本
     * <p>
     * 子控件的id
     *
     * @param viewId 子控件中的文本
     * @param text   返回子控件
     * @return BaseVH
     */
    public BaseVH setText(@IdRes int viewId, String text) {
        if(!TextUtils.isEmpty(text)){
            if(null != getView(viewId) && getView(viewId) instanceof TextView){
                ((TextView) getView(viewId)).setText(text);
            }
        }

        return this;
    }

    /**
    * desc:字符串没内容时隐藏控件
    * Created by congge on 2018/10/12 16:48
    **/
    public BaseVH setTextVisible(@IdRes int viewId, String text) {
        if(getView(viewId) instanceof TextView){
            if(!TextUtils.isEmpty(text)){
                ((TextView) getView(viewId)).setText(text);
                getView(viewId).setVisibility(View.VISIBLE);
            } else {
                getView(viewId).setVisibility(View.GONE);
            }

        }

        return this;
    }


    /**
     * 通过SpannableStringBuilder给TextView设置文本
     *
     * @param viewId View的id
     * @param text   文本
     * @return BaseVH
     */
    public BaseVH setText(@IdRes int viewId, SpannableStringBuilder text) {
        if(!TextUtils.isEmpty(text)){
            if(getView(viewId) instanceof TextView){
                ((TextView) getView(viewId)).setText(text);
            }
        }

        return this;
    }

    /**
     * 通过drawable文件夹中的资源设置图片
     *
     * @param viewId view的id
     * @param resId  文本
     * @return BaseVH
     */
    public BaseVH setImageResource(@IdRes int viewId, @DrawableRes int resId) {
        if(null != getView(viewId) && getView(viewId) instanceof ImageView){
            ImageView imageView = (ImageView) getView(viewId);
            imageView.setImageResource(resId);
        }

        return this;
    }

    /**
    * @desc : 设置网络图片
    * @author : congge on 2020-09-12 10:38
    **/
    public BaseVH setImageUrl(@IdRes int viewId, String url) {
        if(null != getView(viewId) && getView(viewId) instanceof ImageView){
            ImageView imageView = (ImageView) getView(viewId);
            GlideUtils.loadImage(imageView,url);
        }

        return this;
    }

    /**
     * 通过Bitmap设置图片
     *
     * @param viewId view Id
     * @param bitmap Bitmap
     * @return BaseVH
     */
    public BaseVH setImageBitmap(@IdRes int viewId, @NonNull Bitmap bitmap) {
        if(null != getView(viewId) && getView(viewId) instanceof ImageView){
            ImageView imageView = (ImageView) getView(viewId);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }

        return this;
    }

    /**
     * 通过Drawable设置图片
     *
     * @param viewId   View的id
     * @param drawable Drawable
     * @return BaseVH
     */
    public BaseVH setImageDrawable(@IdRes int viewId, @NonNull Drawable drawable) {
        ImageView imageView = (ImageView) getView(viewId);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        return this;
    }

    /**
     * 通过一串数字设置背景色
     *
     * @param viewId View的id
     * @param color  颜色值 16进制
     * @return BaseVH
     */
    public BaseVH setBackgroundColor(@IdRes int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * 通过drawable文件夹设置背景图
     *
     * @param viewId        View的id
     * @param backgroundRes Resource
     * @return BaseVH
     */
    public BaseVH setBackgroundResource(@IdRes int viewId, @DrawableRes int backgroundRes) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }


    /**
     * 通过Drawable设置背景图
     *
     * @param viewId   View的id
     * @param drawable Drawable
     * @return BaseVH
     */
    public BaseVH setBackgroundDrawable(@IdRes int viewId, Drawable drawable) {
        View view = getView(viewId);
        if (drawable != null) {
            view.setBackground(drawable);
        }
        return this;
    }

    /**
     * 通过一串数字设置文字颜色
     *
     * @param viewId    View的id
     * @param textColor 颜色值 16进制
     * @return BaseVH
     */
    public BaseVH setTextColor(@IdRes int viewId, int textColor) {
        TextView textView = (TextView) getView(viewId);
        textView.setTextColor(textColor);
        return this;
    }

    /**
     * 通过float设置透明度
     *
     * @param viewId View的id
     * @param value  透明度  范围:[0.0,1.0]
     * @return BaseVH
     */
    public BaseVH setAlpha(@IdRes int viewId, @FloatRange(from = 0.0, to = 1.0) float
            value) {
        getView(viewId).setAlpha(value);
        return this;
    }

    /**
     * 通过boolean类型设置是否显示
     *
     * @param viewId  View的id
     * @param visible 是否可见 true:可见;  false:不可见,Gone
     * @return BaseVH
     */
    public BaseVH setVisible(@IdRes int viewId, boolean visible) {
        if(null != getView(viewId)){
            getView(viewId).setVisibility(visible ? View.VISIBLE : View.GONE);
        }

        return this;
    }

    /**
     * 缓存子控件上界面的数据
     *
     * @param viewId View的id
     * @param tag    需要缓存的数据
     * @return BaseVH
     */
    public BaseVH setTag(@IdRes int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    /**
     * 设置某一位置子控件的数据
     *
     * @param viewId View的id
     * @param key    数据标识
     * @param tag    数据
     * @return BaseVH
     */
    public BaseVH setTag(@IdRes int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    /**
     * 设置子控件是否选中
     *
     * @param viewId  View的id
     * @param checked true:选中   false:未选中
     * @return BaseVH
     */
    public BaseVH setChecked(@IdRes int viewId, boolean checked) {
        Checkable checkable = (Checkable) getView(viewId);
        checkable.setChecked(checked);
        return this;
    }

    /**
     * 设置子控件的点击事件
     *
     * @param viewId   View的id
     * @param listener OnClickListener监听器
     * @return BaseVH
     */
    public BaseVH setOnClickListener(@IdRes int viewId, @NonNull View.OnClickListener
            listener) {
        View view = getView(viewId);
        if(null != view){
            view.setOnClickListener(listener);
        }

        return this;
    }

    /**
     * 设置子控件的触摸事件
     *
     * @param viewId   View的id
     * @param listener OnTouchListener
     * @return BaseVH
     */
    public BaseVH setOnTouchListener(@IdRes int viewId, @NonNull View.OnTouchListener
            listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    /**
     * 设置子控件的长按事件
     *
     * @param viewId   View的id
     * @param listener OnLongClickListener
     * @return BaseVH
     */
    public BaseVH setOnLongClickListener(@IdRes int viewId, @NonNull View
            .OnLongClickListener
            listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }



    public View getRootView() {
        return itemView;
    }








}
