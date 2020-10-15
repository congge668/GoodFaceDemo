package com.cong.goodfacedemo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.File;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * 图片加载的工具类
 * Created by congge on 2016/5/3.
 */
public class GlideUtils {

    //占位图（后面改成异常图片）
    private static final int placeholderSoWhite = 0xfff6f6f6;
    //异常占位图
    private static final int errorSoWhite = 0xff0000ff;

    /**
     * @desc 加载默认图片
     * @author lzPeng
     * @time 2018/8/16  20:08
     */
    public static void loadImage(ImageView iv, String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholderSoWhite) //占位图
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).asBitmap().load(url).apply(options).into(iv);

    }

    public static void loadImageNoCenterCrop(ImageView iv, String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderSoWhite) //占位图
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).asBitmap().load(url).apply(options).into(iv);

    }

    /**
     * @desc 加载默认图片
     * @author lzPeng
     * @time 2018/8/16  20:08
     */
    public static void loadImage(ImageView iv, int res) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholderSoWhite) //占位图
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(res).apply(options).into(iv);

    }

    public static void loadFitImage(ImageView iv, int res) {
        RequestOptions options = new RequestOptions()
                .centerInside()
                .placeholder(placeholderSoWhite) //占位图
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(res).apply(options).into(iv);

    }

    /**
     * @desc 加载默认图片
     * @author lzPeng
     * @time 2018/8/16  20:08
     */
    public static void loadImage(ImageView iv, File file) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholderSoWhite) //占位图
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(file).apply(options).into(iv);
    }

    public static void loadImageFitCenter(ImageView iv, File file) {
        RequestOptions options = new RequestOptions()
                .fitCenter()
                .placeholder(placeholderSoWhite) //占位图
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(file).apply(options).into(iv);
    }


    /**
     * 加载圆形图片
     */
    public static void loadCircleImage(ImageView iv, String url) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()//设置圆形
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).asBitmap().load(url).apply(options).into(iv);
    }

    /**
     * 加载圆形图片
     */
    public static void loadCircleImage(ImageView iv, File file) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()//设置圆形
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(file).apply(options).into(iv);
    }


    /**
     * 指定图片大小;使用override()方法指定了一个图片的尺寸。
     * Glide现在只会将图片加载成width*height像素的尺寸，而不会管你的ImageView的大小是多少了。
     * 如果你想加载一张图片的原始尺寸的话，可以使用Target.SIZE_ORIGINAL关键字----override(Target.SIZE_ORIGINAL)
     *
     * @param url
     * @param iv
     * @param width
     * @param height
     */
    public static void loadImageSize(ImageView iv, String url, int width, int height) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholderSoWhite) //占位图
                .override(width, height)
                // .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).asBitmap().load(url).apply(options).into(iv);

    }


    /**
     * 禁用内存缓存功能
     * diskCacheStrategy()方法基本上就是Glide硬盘缓存功能的一切，它可以接收五种参数：
     * <p>
     * DiskCacheStrategy.NONE： 表示不缓存任何内容。
     * DiskCacheStrategy.DATA： 表示只缓存原始图片。
     * DiskCacheStrategy.RESOURCE： 表示只缓存转换过后的图片。
     * DiskCacheStrategy.ALL ： 表示既缓存原始图片，也缓存转换过后的图片。
     * DiskCacheStrategy.AUTOMATIC： 表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）。
     */

    public static void loadImageSizekipMemoryCache(ImageView iv, String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderSoWhite) //占位图
                .skipMemoryCache(true)//禁用掉Glide的内存缓存功能
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(url).apply(options).into(iv);

    }


    /**
     * 预先加载图片
     * 在使用图片之前，预先把图片加载到缓存，调用了预加载之后，我们以后想再去加载这张图片就会非常快了，
     * 因为Glide会直接从缓存当中去读取图片并显示出来
     */
    public static void preloadImage(Context context, String url) {
        Glide.with(context)
                .load(url)
                .preload();
    }

    /**
     * 加载圆角图片
     */
    public static void loadRoundCircleImage(ImageView iv, String url) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()//设置圆形
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .bitmapTransform(new RoundedCornersTransformation(45, 0, RoundedCornersTransformation.CornerType.ALL))
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).asBitmap().load(url).apply(options).into(iv);

    }

    /**
     * 加载自定义圆角图片
     */
    public static void loadRoundCircleImage(ImageView iv, int res, int corner ) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()//设置圆形
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .bitmapTransform(new RoundedCornersTransformation( corner, 0, RoundedCornersTransformation.CornerType.ALL))
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(res).apply(options).into(iv);

    }

    /**
     * 加载自定义圆形图片
     */
    public static void loadRoundCircleImage(ImageView iv, int res) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()//设置圆形
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).asBitmap().load(res).apply(options).into(iv);

    }

    public static void loadRoundCircleImage(ImageView iv, String url, int corner ) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .circleCrop()//设置圆形
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .bitmapTransform(new RoundedCornersTransformation( corner, 0, RoundedCornersTransformation.CornerType.ALL))
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(url).apply(options).into(iv);

    }


    /**
     * 加载圆角图片-指定任意部分圆角（图片上、下、左、右四个角度任意定义）
     *
     * @param url
     * @param iv
     * @param type
     */
    public static void loadCustRoundCircleImage(ImageView iv, String url, RoundedCornersTransformation.CornerType type) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .bitmapTransform(new RoundedCornersTransformation( 45, 0, type))
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(iv.getContext()).asBitmap().load(url).apply(options).into(iv);
    }


    /**
     * 加载模糊图片（自定义透明度）
     *
     * @param url
     * @param iv
     * @param blur 模糊度，一般1-100够了，越大越模糊
     */
    public static void loadBlurImage(ImageView iv, String url, int blur) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .bitmapTransform(new BlurTransformation( blur))
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).asBitmap().load(url).apply(options).into(iv);
    }

    /*
     *加载灰度(黑白)图片（自定义透明度）
     */
    public static void loadBlackImage(ImageView iv, String url) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite)
                //.priority(Priority.HIGH)
                .bitmapTransform(new GrayscaleTransformation())
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(iv.getContext()).load(url).apply(options).into(iv);
    }

    /**
     * Glide.with(this).asGif()    //强制指定加载动态图片
     * 如果加载的图片不是gif，则asGif()会报错， 当然，asGif()不写也是可以正常加载的。
     * 加入了一个asBitmap()方法，这个方法的意思就是说这里只允许加载静态图片，不需要Glide去帮我们自动进行图片格式的判断了。
     * 如果你传入的还是一张GIF图的话，Glide会展示这张GIF图的第一帧，而不会去播放它。
     *
     * @param url 例如：https://image.niwoxuexi.com/blog/content/5c0d4b1972-loading.gif
     * @param iv
     */
    public void loadGif(ImageView iv, String url) {
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite);
        Glide.with(iv.getContext())
                .load(url)
                .apply(options)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(iv);

    }

    public static void loadGif(ImageView iv, int url) {
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderSoWhite)
                .error(errorSoWhite);
        Glide.with(iv.getContext())
                .load(url)
                .apply(options)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(iv);

    }

    public void downloadImage(final Context context, final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FutureTarget<File> target = Glide.with(context)
                            .asFile()
                            .load(url)
                            .submit();
                    final File imageFile = target.get();
                    Log.d("logcat", "下载好的图片文件路径=" + imageFile.getPath());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(iv.getContext(), imageFile.getPath(), Toast.LENGTH_LONG).show();
//                        }
//                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


}