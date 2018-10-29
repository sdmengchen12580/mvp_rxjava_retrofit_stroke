package com.bihucj.mcandroid.mvp.model;

import rx.Subscription;

/**
 * Created by 孟晨 on 2018/9/19.
 */

public interface ModelDate {

    Subscription loadDate(int page,LoadDateListener loadDateListener);

    interface LoadDateListener {
        //FIXME code=0 失败
        //FIXME code=1 成功
        void complete(Integer code, String erroeMsg, Object list);
    }
}
