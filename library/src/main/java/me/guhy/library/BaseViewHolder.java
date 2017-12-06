package me.guhy.library;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by GUHY on 2017/5/8.
 */

public abstract class BaseViewHolder<D> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView, final OnItemClickListener onItemClickedListener){
        super(itemView);
        if(onItemClickedListener!=null){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickedListener.onItemClicked(v,getAdapterPosition());
                }
            });
        }
    }
    public abstract void setData(D d);

    public interface OnItemClickListener{
        void onItemClicked(View v,int position);
    }
}
