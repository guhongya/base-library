package me.guhy.library;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by guhongya on 2017/7/30.
 */

public class RecyclerDecorate extends RecyclerView.ItemDecoration {
    private int width;
    private int height;
    private int color;
    private final Rect mBounds = new Rect();
    private Drawable mDivider;
    private boolean transparent;
    public RecyclerDecorate() {
        super();
        mDivider=new ColorDrawable(Color.LTGRAY);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return;
        }
        if(!transparent) {
            draw(c, parent);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0,0,width,height);
    }

    public void setColor(int color){
        this.color=color;
        mDivider=new ColorDrawable(color);
    }
    public void setTransparent(boolean transparent){
        this.transparent=transparent;
    }
    public void setDividerSize(int widht,int height){
       this.width=widht;
        this.height=height;
    }
    private void draw(Canvas canvas,RecyclerView parent) {
        canvas.save();
        final int left;
        int right;
        left = 0;
        right = parent.getWidth();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            parent.getDecoratedBoundsWithMargins(child, mBounds);
            final int bottom = mBounds.bottom + Math.round(ViewCompat.getTranslationY(child));
            final int top = bottom - height;
            //right=Math.round(ViewCompat.getTranslationX(child));
            mDivider.setBounds(left, top, right+width, bottom);
            mDivider.draw(canvas);
        }
        canvas.restore();
    }
}
