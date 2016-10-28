package com.example.administrator.watchsexygirls.retrofit;

import com.example.administrator.watchsexygirls.model.TiangouBase;
import com.example.administrator.watchsexygirls.model.response.FenquDetail;
import com.example.administrator.watchsexygirls.model.response.ImageDetail;
import com.example.administrator.watchsexygirls.model.response.RootFenlei;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by qianpeng on 2016/10/28.
 */

public interface ApiInterface {
    /**
     * 获取总分类列表
     * @return
     */
    @GET("tnfs/api/classify")
    public Observable<TiangouBase<List<RootFenlei>>> getRootFenlei();

    /**
     * 获取小分类套图列表 如：丝袜美腿
     * @param page
     * @param rows
     * @param id
     * @return
     */
    @GET("tnfs/api/list")
    public Observable<TiangouBase<List<FenquDetail>>> getPicLists(@Query("page")int page,@Query("rows")int rows,@Query("id")int id);

    /**
     * 获取套图内图片列表
     * @param id
     * @return
     */
    @GET("tnfs/api/show/default.jpg_480x854")
    public Observable<ImageDetail> showImages(@Query("id") int id);
}
