package com.bihucj.mcandroid.mvp.mainmvp;

import com.bihucj.mcandroid.http.main.MainLoader;
import com.bihucj.mcandroid.http.main.bean.GetGoodsVarietyCodesBean;

import org.lcsyjt.mylibrary.http.callback.HttpListener;

import rx.Subscription;

/**
 * Created by 孟晨 on 2018/10/29.
 */

public interface MainCompany {
    //第一步：确定ui层需要哪些操控ui地方，定义成接口
    interface IMainView {

        //第一次请求数据前的操作
        void showLoading();

        //请求数据第一页，数据为空的操作
        void showNullView();

        void showDate(GetGoodsVarietyCodesBean bean, boolean isRefresh);

        void showFail(String errorMsg);
    }

    //第二步：确定p层需要的model层拿数据接口
    interface MainDate {

        Subscription loadDate(int page, LoadDateListener loadDateListener);

        interface LoadDateListener {
            //FIXME code=0 失败
            //FIXME code=1 成功
            void complete(Integer code, String erroeMsg, Object list);
        }
    }

    //第三步：model数据接口实现类
    class IModelDate implements MainDate {

        @Override
        public Subscription loadDate(int page, final LoadDateListener loadDateListener) {
            /**
             * 1.选择将此model层的实现放到管理接口中
             * 2.将订阅事件通过subscription先返回出去，通过业务层的CompositeSubscription做事件管理
             * 3.接口的数据通过，接口中的接口去返回，这样数据好了就去通知页面，页面不会等待数据而无法响应其他操作
             */
            Subscription subscription = null;
            HttpListener<GetGoodsVarietyCodesBean> httpListener = new HttpListener<GetGoodsVarietyCodesBean>() {
                @Override
                public void onError(String errorMsg) {
                    loadDateListener.complete(0, errorMsg, null);
                }

                @Override
                public void onSuccess(GetGoodsVarietyCodesBean date) {
                    //FIXME 后台还做其他状态code区分，另说
                    loadDateListener.complete(1, "success", date);
                }
            };
            MainLoader mainLoader = new MainLoader(MainLoader.BASEURL);
            subscription = mainLoader.getBd(httpListener);
            return subscription;
        }
    }
}
