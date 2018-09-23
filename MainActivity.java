package com.example.gt.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private RecyclerView rv_recycleView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_recycleView = findViewById(R.id.rv_recycleView);
        adapter = new MyAdapter(this);
        rv_recycleView.setLayoutManager(new GridLayoutManager(this, 2));
        rv_recycleView.addItemDecoration(new CustomItemDecoration(this));
        rv_recycleView.setAdapter(adapter);
        adapter.setData(getData());
        adapter.notifyDataSetChanged();
    }

    private List<Bean> getData() {
        List<Bean> beanList = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            Bean bean = new Bean();
            bean.setName("李小" + i);
            bean.setAge(i);
            if (i / 3 == 0) {
                bean.setSex("男");
            } else {
                bean.setSex("女");
            }
            beanList.add(bean);
        }
        return beanList;
    }
}
