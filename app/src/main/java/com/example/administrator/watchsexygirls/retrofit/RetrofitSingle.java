package com.example.administrator.watchsexygirls.retrofit;

/**
 * Created by qianpeng on 2016/8/19.
 */
public class RetrofitSingle  {

    private RetrofitSingle(){
        //do nothing
    }
    private static ApiInterface serviceApi;

    /**
     * 加了同步锁的单例模式
     * @return
     */
    public static ApiInterface getInstance(){
            if(serviceApi==null){
                synchronized (RetrofitSingle.class){
                    serviceApi = new RetrofitBuilder().createServiceClass(ApiInterface.class);
                }
            }
        return serviceApi;
    }
}
