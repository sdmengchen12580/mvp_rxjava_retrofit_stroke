package com.bihucj.mcandroid.http.main;

import com.bihucj.mcandroid.http.main.bean.GetGoodsVarietyCodesBean;

import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 孟晨 on 2018/5/25.
 */

public interface MainApi {

    //FIXME 1.获取产品
    @Headers("Cache-Control:public,max-age=43200")
    @POST("getGoodsVarietyCodes")
    Observable<GetGoodsVarietyCodesBean> getType();

}
