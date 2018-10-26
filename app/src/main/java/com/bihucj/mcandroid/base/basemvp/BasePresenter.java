package com.bihucj.mcandroid.base.basemvp;

import java.lang.ref.WeakReference;

/**
 * Created by 孟晨 on 2018/9/19.
 */

public class BasePresenter<T> {

    protected WeakReference<T> reference;

    public void attachView(T view) {
        reference = new WeakReference<>(view);
    }

    public void disAttchView() {
        reference.clear();
    }
}
