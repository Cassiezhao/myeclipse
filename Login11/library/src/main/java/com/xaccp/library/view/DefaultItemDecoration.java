package com.xaccp.library.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xaccp.library.R;
import com.xaccp.library.util.AppHolder;

/**
 * Created by tao.zeng on 2016/8/3.
 */
public class DefaultItemDecoration extends RecyclerView.ItemDecoration {


    private Drawable divider = AppHolder.getResource().getDrawable(R.drawable.list_item_shape_selected);

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        // 获取左右的内边距
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        // 获取所有的子item数量
        final int childCount = parent.getChildCount();
        // 循环添加分割线
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin +
                    Math.round(ViewCompat.getTranslationY(child));
            final int bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, 1);
    }
}
