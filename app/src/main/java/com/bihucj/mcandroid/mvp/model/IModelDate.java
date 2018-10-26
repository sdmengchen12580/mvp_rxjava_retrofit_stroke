package com.bihucj.mcandroid.mvp.model;

import com.bihucj.mcandroid.http.main.MainLoader;
import com.bihucj.mcandroid.http.main.bean.GetGoodsVarietyCodesBean;

import org.lcsyjt.mylibrary.http.callback.HttpListener;

import rx.Subscription;

/**
 * Created by 孟晨 on 2018/9/19.
 */

public class IModelDate implements ModelDate {

    @Override
    public Subscription loadDate(final LoadDateListener loadDateListener) {
        Subscription subscription = null;
        HttpListener<GetGoodsVarietyCodesBean> httpListener = new HttpListener<GetGoodsVarietyCodesBean>() {
            @Override
            public void onError(String errorMsg) {
                loadDateListener.complete(0, errorMsg, null);
            }

            @Override
            public void onSuccess(GetGoodsVarietyCodesBean date) {
                //FIXME 后台还做cedo区分，另说
                loadDateListener.complete(1, "success", date);
            }
        };
        MainLoader mainLoader = new MainLoader(MainLoader.BASEURL);
        subscription = mainLoader.getBd(httpListener);
        return subscription;
    }
}
