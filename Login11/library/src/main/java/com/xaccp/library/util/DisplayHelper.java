package com.xaccp.library.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xaccp.library.R;

/**
 * Created by tao.zeng on 2016/9/3.
 */
public final class DisplayHelper {

    private DisplayHelper() {
    }


    /**
     * dp转换成px
     *
     * @return 返回
     */
    public static int dp2px(int dp) {
        DisplayMetrics metrics = getDisplayMetrics();
        return (int) (dp * metrics.density + 0.5f);
    }

    public static float px2dp(int px) {
        DisplayMetrics metrics = getDisplayMetrics();
        return px / metrics.density + 0.5f;
    }

    private static DisplayMetrics getDisplayMetrics() {
        return AppHolder.getContext().getResources().getDisplayMetrics();
    }

    /**
     * 在UI线程执行Runnable
     *
     * @param task
     */
    public synchronized static void postInUIThread(Runnable task) {
        if (task != null) {
            if (Thread.currentThread().getId() != AppHolder.getUIThreadID()) {
                AppHolder.getUIThreadHandler().post(task);
            } else {
                task.run();
            }
        }
    }

    public static void removeParent(View v) {
        if (v != null) {
            ViewParent parent = v.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(v);
            }
        }
    }

    /**
     * 设置View margin
     *
     * @param v
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public static void setMargins(View v, int left, int top, int right, int bottom) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            v.requestLayout();
        }
    }

    /**
     * 加载图片
     *
     * @param context
     * @param path
     * @param view
     */
    public static void loadImage(Context context, String path, ImageView view) {
        Glide.with(context)
                .load(path)// 加载图片的路径
                .error(R.drawable.ic_launcher)// 加载失败时显示的图片
                .crossFade()//淡入效果
                .diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存策略
                .into(view);// 加载到该控件
    }
}
