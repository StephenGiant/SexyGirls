package com.example.administrator.watchsexygirls.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.administrator.watchsexygirls.R;
import com.example.administrator.watchsexygirls.adapter.ImgDetailAdapter;
import com.example.administrator.watchsexygirls.model.response.ImageDetail;
import com.example.administrator.watchsexygirls.retrofit.RetrofitSingle;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/28.
 */

public class TaotuDetailAct extends AppCompatActivity {
    @Bind(R.id.rv_taotuDetail)
    RecyclerView rvTaotuDetail;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_taotudetail);
        ButterKnife.bind(this);
        int galleryID = getIntent().getExtras().getInt("galleryID");
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvTaotuDetail.setLayoutManager(staggeredGridLayoutManager);
        RetrofitSingle.getInstance().showImages(galleryID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ImageDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ImageDetail imageDetail) {
                        Toast.makeText(TaotuDetailAct.this,imageDetail.getTitle(),Toast.LENGTH_SHORT).show();
                        ImgDetailAdapter imgDetailAdapter = new ImgDetailAdapter(TaotuDetailAct.this, imageDetail.getList());
                        rvTaotuDetail.setAdapter(imgDetailAdapter);

                    }
                });
    }
}
