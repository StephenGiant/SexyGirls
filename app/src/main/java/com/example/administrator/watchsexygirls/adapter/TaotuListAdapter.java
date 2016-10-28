package com.example.administrator.watchsexygirls.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.watchsexygirls.R;
import com.example.administrator.watchsexygirls.application.ApplicationConfig;
import com.example.administrator.watchsexygirls.model.response.FenquDetail;
import com.example.administrator.watchsexygirls.viewholder.MyBaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/10/28.
 */

public class TaotuListAdapter extends MyBaseAdapter<FenquDetail, TaotuListAdapter.TaoTulistViewHolder> {



    public TaotuListAdapter(Activity activity, List<FenquDetail> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(TaoTulistViewHolder holder, FenquDetail data, int position) {
        String url = ApplicationConfig.ImageHost + data.getImg();

        Glide.with(mActivity).load(url).override(400,668).error(R.drawable.sexymm).centerCrop().into(holder.titleImg);
        holder.titleDes.setText(data.getTitle());
    }

    @Override
    public TaoTulistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_taotutitle, parent, false);
        return new TaoTulistViewHolder(view);

    }

    class TaoTulistViewHolder extends MyBaseViewHolder {

        @Bind(R.id.title_img)
        ImageView titleImg;
        @Bind(R.id.title_des)
        TextView titleDes;
        public TaoTulistViewHolder(View itemView) {
            super(itemView);
        }
    }
}
