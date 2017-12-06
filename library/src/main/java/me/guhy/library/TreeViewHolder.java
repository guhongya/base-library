package me.guhy.library;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by guhongya on 2017/8/7.
 */

public abstract class TreeViewHolder<T extends TreeItem> extends RecyclerView.ViewHolder {
    public TreeViewHolder(View itemView,int type) {
        super(itemView);
    }

    public abstract void setData(T t);
}
