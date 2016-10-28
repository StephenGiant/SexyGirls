package com.example.administrator.watchsexygirls.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.watchsexygirls.R;
import com.example.administrator.watchsexygirls.adapter.AreasAdapter;
import com.example.administrator.watchsexygirls.model.TiangouBase;
import com.example.administrator.watchsexygirls.model.response.RootFenlei;
import com.example.administrator.watchsexygirls.retrofit.ApiInterface;
import com.example.administrator.watchsexygirls.retrofit.RetrofitSingle;
import com.example.administrator.watchsexygirls.view.RecyclerItemClickListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv_areas)
    RecyclerView rvAreas;
    private ApiInterface apiInterface;
    private List<RootFenlei> tngou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        apiInterface = RetrofitSingle.getInstance();
        apiInterface.getRootFenlei().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TiangouBase<List<RootFenlei>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TiangouBase<List<RootFenlei>> listTiangouBase) {
                        tngou = listTiangouBase.getTngou();
                        AreasAdapter areasAdapter = new AreasAdapter(MainActivity.this, tngou);
                        rvAreas.setAdapter(areasAdapter);

                    }
                });
        rvAreas.addOnItemTouchListener(new RecyclerItemClickListener(this) {
    @Override
    protected void onItemClick(View view, int position) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,TaotuListAct.class);
        Bundle bundle = new Bundle();
        bundle.putInt("AreaID",tngou.get(position).getId());
        intent.putExtras(bundle);
        MainActivity.this.startActivity(intent);
    }
});
    }
}
