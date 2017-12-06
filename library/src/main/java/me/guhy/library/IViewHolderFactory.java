package me.guhy.library;

import android.view.View;

/**
 * Created by GUHY on 2017/5/8.
 */

public interface IViewHolderFactory<T> {
        T generatorViewHolder(View view, BaseViewHolder.OnItemClickListener onItemClickListener);
}
