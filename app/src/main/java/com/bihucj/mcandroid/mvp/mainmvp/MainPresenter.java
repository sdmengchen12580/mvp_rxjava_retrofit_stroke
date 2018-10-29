package com.bihucj.mcandroid.mvp.mainmvp;

import android.util.Log;

import com.bihucj.mcandroid.base.basemvp.BasePresenter;
import com.bihucj.mcandroid.custom.Config;
import com.bihucj.mcandroid.http.main.bean.GetGoodsVarietyCodesBean;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 孟晨 on 2018/9/19.
 */

public class MainPresenter<T extends MainCompany.IMainView> extends BasePresenter<T> {

    //管理订阅
    private Subscription subGetBaiduDate;
    private CompositeSubscription compositeSubscription;
    //model
    private MainCompany.IModelDate iModelDate;
    //分页加载首页
    private int page = 1;
    //是否页面第一次加载数据
    private boolean isFirstRequest = true;
    //是否接口返回的第一页数据
    private boolean isFirstPageDate = true;

    public MainPresenter() {
        compositeSubscription = new CompositeSubscription();
        iModelDate = new MainCompany.IModelDate();
    }

    //取消订阅
    public void cancelSub() {
        if (compositeSubscription != null) compositeSubscription.clear();
        subGetBaiduDate = null;
    }

    //刷新则page++
    public void getDate(boolean isRefresh) {
        if (isRefresh) {
            page = 1;
        } else {
            page++;
        }
        if (reference.get() != null) {
            if (isFirstRequest) {
                isFirstRequest = false;
                //显示弹窗
                reference.get().showLoading();
            }
            if (iModelDate != null) {
                //先取消上次订阅
                cancelSub();
                //拿到sub，方便手动取消订阅
                subGetBaiduDate = loadDate(page, isRefresh);
                //添加到订阅管理
                compositeSubscription.add(subGetBaiduDate);
                Log.e(Config.TAG, "请求为空：" + (subGetBaiduDate == null));
            }
        }
    }

    //请求第mPage页数据,根据isRefresh判断数据是clear还是add
    private Subscription loadDate(int mPage, final boolean isRefresh) {
        return iModelDate.loadDate(mPage, new MainCompany.IModelDate.LoadDateListener() {
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
                            //接口第一页数据为空，显示空布局
                            if (isFirstPageDate) {
                                isFirstPageDate = false;
                                if (((GetGoodsVarietyCodesBean) dateBean).getData().getResponse().getRows().size() == 0) {
                                    reference.get().showNullView();
                                    return;
                                }
                            }
                            reference.get().showDate((GetGoodsVarietyCodesBean) dateBean, isRefresh);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
