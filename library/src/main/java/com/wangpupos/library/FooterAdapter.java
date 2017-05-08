package com.wangpupos.library;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by GUHY on 2017/5/8.
 */

public class FooterAdapter extends RecyclerView.Adapter {
    private RecyclerView.Adapter mAdapter;
    List<View> footers;
    public FooterAdapter(List<View> footers){
        this.footers=footers;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType<mAdapter.getItemCount()){
            return mAdapter.onCreateViewHolder(parent,viewType);
        }else{
            return new CommonViewHolder(footers.get(viewType-mAdapter.getItemCount()));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position<mAdapter.getItemCount()){
            mAdapter.onBindViewHolder(holder,position);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        mAdapter.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemViewType(int position) {
        if(position<mAdapter.getItemCount()) {
            return mAdapter.getItemViewType(position);
        }else{
            return position;
        }
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        mAdapter.setHasStableIds(hasStableIds);
    }

    @Override
    public long getItemId(int position) {
        return mAdapter.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount()+footers.size();
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        if(holder.getAdapterPosition()<mAdapter.getItemCount()) {
            mAdapter.onViewRecycled(holder);
        }
    }

    @Override
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder holder) {
        if(holder.getAdapterPosition()<mAdapter.getItemCount()) {
            return mAdapter.onFailedToRecycleView(holder);
        }else {
            return false;
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        if(holder.getAdapterPosition()<mAdapter.getItemCount()) {
            mAdapter.onViewAttachedToWindow(holder);
        }
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        if(holder.getAdapterPosition()<mAdapter.getItemCount()) {
            mAdapter.onViewDetachedFromWindow(holder);
        }
    }

    @Override
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        mAdapter.registerAdapterDataObserver(observer);
    }

    @Override
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        mAdapter.unregisterAdapterDataObserver(observer);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        mAdapter.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        mAdapter.onDetachedFromRecyclerView(recyclerView);
    }
}
