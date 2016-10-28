package com.example.administrator.watchsexygirls.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.watchsexygirls.R;
import com.example.administrator.watchsexygirls.model.response.RootFenlei;
import com.example.administrator.watchsexygirls.viewholder.MyBaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/10/28.
 */

public class AreasAdapter extends MyBaseAdapter<RootFenlei, AreasAdapter.AreaViewHolder> {


    @Override
    protected void bindItemData(AreaViewHolder holder, RootFenlei data, int position) {
        holder.areaName.setText(data.getName());
        //first commit
    }

    @Override
    public AreaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_area, parent, false);
        AreaViewHolder viewHolder = new AreaViewHolder(view);
        return viewHolder;
    }

    public AreasAdapter(Activity activity, List<RootFenlei> data) {
        super(activity, data);
    }

    class AreaViewHolder extends MyBaseViewHolder {
        @Bind(R.id.area_name)
        TextView areaName;
        public AreaViewHolder(View itemView) {
            super(itemView);
        }
    }
}
