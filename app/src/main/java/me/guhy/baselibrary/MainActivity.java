package me.guhy.baselibrary;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.guhy.baselibrary.databinding.ActivityMainBinding;
import me.guhy.baselibrary.databinding.ItemRecycleBinding;
import me.guhy.library.BaseRecycleAdapter;
import me.guhy.library.BaseViewHolder;
import me.guhy.library.IViewHolderFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mMainBing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBing = DataBindingUtil.setContentView(this, R.layout.activity_main);
        iniView();
    }

    private void iniView() {
        mMainBing.rvContent.setLayoutManager(new LinearLayoutManager(this));
        BaseRecycleAdapter<String, MyViewHolder> recycleAdapter = new BaseRecycleAdapter<>(generatorData(20), R.layout.item_recycle);
        recycleAdapter
                .setFactory(new IViewHolderFactory<MyViewHolder>() {
                    @Override
                    public MyViewHolder generatorViewHolder(View view, BaseViewHolder.OnItemClickListener onItemClickListener) {
                        return new MyViewHolder(view, onItemClickListener);
                    }
                })
                .setOnItemClickListener(new BaseViewHolder.OnItemClickListener() {
                    @Override
                    public void onItemClicked(View v, int position) {
                        Toast.makeText(MainActivity.this,String.valueOf(position),Toast.LENGTH_LONG).show();
                    }
                });
        mMainBing.rvContent.setAdapter(recycleAdapter);

    }

    private List<String> generatorData(int num) {
        List<String> result = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }

}

class MyViewHolder extends BaseViewHolder<String> {
    ItemRecycleBinding item;

    public MyViewHolder(View itemView, OnItemClickListener onItemClickedListener) {
        super(itemView, onItemClickedListener);
        item = DataBindingUtil.bind(itemView);
    }

    @Override
    public void setData(String s) {
        item.setPosition(s);
    }
}