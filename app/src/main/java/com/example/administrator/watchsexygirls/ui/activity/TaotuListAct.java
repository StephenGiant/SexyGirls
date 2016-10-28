package com.example.administrator.watchsexygirls.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.watchsexygirls.R;
import com.example.administrator.watchsexygirls.adapter.TaotuListAdapter;
import com.example.administrator.watchsexygirls.model.TiangouBase;
import com.example.administrator.watchsexygirls.model.response.FenquDetail;
import com.example.administrator.watchsexygirls.retrofit.ApiInterface;
import com.example.administrator.watchsexygirls.retrofit.RetrofitSingle;
import com.example.administrator.watchsexygirls.view.RecyclerItemClickListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/28.
 */

public class TaotuListAct extends AppCompatActivity {
    @Bind(R.id.rv_taotulist)
    RecyclerView rvTaotulist;
    private ApiInterface apiInterface;
    private TaotuListAdapter taotuListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_taotulist);
        ButterKnife.bind(this);
            rvTaotulist.addOnItemTouchListener(new RecyclerItemClickListener(this) {
                @Override
                protected void onItemClick(View view, int position) {
                    //do nothing
                    Intent intent = new Intent(TaotuListAct.this, TaotuDetailAct.class);
                    TaotuListAct.this.startActivity(intent);
                }
            });
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("AreaID");
        apiInterface = RetrofitSingle.getInstance();
        apiInterface.getPicLists(1,20,id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TiangouBase<List<FenquDetail>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TiangouBase<List<FenquDetail>> listTiangouBase) {
                        taotuListAdapter = new TaotuListAdapter(TaotuListAct.this, listTiangouBase.getTngou());
                        rvTaotulist.setAdapter(taotuListAdapter);


                    }
                });
    }
}
