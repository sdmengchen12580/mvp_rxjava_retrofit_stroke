package com.bihucj.mcandroid;

import android.app.Application;

import com.bihucj.mcandroid.utils.AppUtils;


/**
 * Created by 孟晨 on 2018/7/23.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(App.this);
    }
}
