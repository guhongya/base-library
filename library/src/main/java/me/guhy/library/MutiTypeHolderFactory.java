package me.guhy.library;

import android.view.View;

/**
 * Created by guhongya on 2017/8/7.
 */

public interface MutiTypeHolderFactory<T> {
    T generatorViewHolder(View view, int type);
}
