package com.wangpupos.library;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by GUHY on 2017/5/8.
 */

public abstract class BaseViewHolder<D> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        this(itemView,null);
    }
    public BaseViewHolder(View itemView,OnItemClickListener onItemClickedListener){
        super(itemView);
    }
    public abstract void setData(D d);

    public interface OnItemClickListener{
        void onItemClicked(View v,int position);
    }
}
