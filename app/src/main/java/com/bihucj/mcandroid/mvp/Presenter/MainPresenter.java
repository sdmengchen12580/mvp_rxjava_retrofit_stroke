package com.bihucj.mcandroid.mvp.Presenter;

import android.support.v4.app.NavUtils;
import android.util.Log;
import android.util.NoSuchPropertyException;

import com.bihucj.mcandroid.base.basemvp.BasePresenter;
import com.bihucj.mcandroid.custom.Config;
import com.bihucj.mcandroid.http.main.bean.GetGoodsVarietyCodesBean;
import com.bihucj.mcandroid.mvp.model.IModelDate;
import com.bihucj.mcandroid.mvp.view.IDateView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 孟晨 on 2018/9/19.
 */


public class MainPresenter<T extends IDateView> extends BasePresenter<T> {

    IModelDate iModelDate = new IModelDate();
    private Subscription subGetBaiduDate;
    private CompositeSubscription compositeSubscription;

    public MainPresenter() {
        compositeSubscription = new CompositeSubscription();
    }

    //取消订阅
    public void cancelSub() {
        if (compositeSubscription != null) compositeSubscription.clear();
        subGetBaiduDate = null;
    }

    public void getDate() {
        if (reference.get() != null) {
            //显示弹窗
            reference.get().showLoading();
            if (iModelDate != null) {
                //FIXME 拿到sub，方便手动取消订阅
                subGetBaiduDate = iModelDate.loadDate(new IModelDate.LoadDateListener() {
                    @Override
                    public void complete(Integer code, String erroeMsg, Object dateBean) {
                        switch (code) {
                            case 0:
                                if (reference.get() != null) {
                                    reference.get().showFail(erroeMsg);
                                }
                                break;
                            case 1:
                                if (reference.get() != null) {
                                    if (dateBean == null) return;
                                    reference.get().showDate((GetGoodsVarietyCodesBean) dateBean);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                });
                compositeSubscription.add(subGetBaiduDate);
                Log.e(Config.TAG, "请求为空：" + (subGetBaiduDate == null));
            }
        }
    }


}
