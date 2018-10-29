package com.bihucj.mcandroid.http.main;

import com.bihucj.mcandroid.http.main.bean.GetGoodsVarietyCodesBean;
import com.bihucj.mcandroid.utils.OtherUtils;

import org.lcsyjt.mylibrary.http.RetrofitManager;
import org.lcsyjt.mylibrary.http.callback.HttpListener;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 孟晨 on 2018/5/25.
 */

public class MainLoader {

    private MainApi mainApi;

    public static final String BASEURL = "http://www-dev.lcsyjt.com/fz.syjt/api/syjt/shop/";

    public MainLoader(String baseUrl) {
        mainApi = RetrofitManager.getAGanYunApi(MainApi.class, baseUrl);
    }

    // FIXME 1.获取产品
    private Subscription getType;

    public Subscription getBd(HttpListener httpListener) {
        getType = mainApi.getType()
                .compose(OtherUtils.RxSchedulerUtils.<GetGoodsVarietyCodesBean>io_main())
                .subscribe(httpListener);
        return getType;
    }
}
