package com.example.administrator.watchsexygirls.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.watchsexygirls.R;
import com.example.administrator.watchsexygirls.application.ApplicationConfig;
import com.example.administrator.watchsexygirls.model.response.ImageDetail;
import com.example.administrator.watchsexygirls.viewholder.MyBaseViewHolder;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/10/28.
 */

public class ImgDetailAdapter extends MyBaseAdapter<ImageDetail.ListBean, ImgDetailAdapter.ImageDetailViewHolder> {

    public ImgDetailAdapter(Activity activity, List<ImageDetail.ListBean> data) {
        super(activity, data);
    }

    @Override
    protected void bindItemData(ImageDetailViewHolder holder, ImageDetail.ListBean data, int position) {
        Log.i(""+position,data.getGallery()+"");
        Glide.with(mActivity).load(ApplicationConfig.ImageHost + data.getSrc()).thumbnail(0.5f).fitCenter().error(R.drawable.sexymm).into(holder.picDetail);
    }

    @Override
    public ImageDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_taotus, parent, false);
        return new ImageDetailViewHolder(view);

    }

    class ImageDetailViewHolder extends MyBaseViewHolder {
        @Bind(R.id.pic_detail)
        ImageView picDetail;

        public ImageDetailViewHolder(View itemView) {
            super(itemView);
        }
    }
}
