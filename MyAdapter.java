package com.example.gt.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器
 * Created by gt on 2018/9/23.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    private List<Bean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Bean> beans) {
        if (beans != null && beans.size() > 0) {
            list.addAll(beans);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false));
        } else {
            return new MyViewHolder1(LayoutInflater.from(context).inflate(R.layout.layout_item1, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.tv_name.setText(list.get(position).getName());
            myViewHolder.tv_age.setText(list.get(position).getAge() + "");

        } else if (holder instanceof MyViewHolder1) {
            MyViewHolder1 myViewHolder1 = (MyViewHolder1) holder;
            myViewHolder1.tv_name.setText(list.get(position).getName());
            myViewHolder1.tv_age.setText(list.get(position).getAge() + "");
            myViewHolder1.tv_sex.setText(list.get(position).getSex() + "");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position / 2 == 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_age;

        MyViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_age = itemView.findViewById(R.id.tv_age);
        }
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_age;
        TextView tv_sex;

        MyViewHolder1(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_age = itemView.findViewById(R.id.tv_age);
            tv_sex = itemView.findViewById(R.id.tv_sex);
        }
    }
}
