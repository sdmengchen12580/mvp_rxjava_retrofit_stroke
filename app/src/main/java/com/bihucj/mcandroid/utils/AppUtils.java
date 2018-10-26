package com.bihucj.mcandroid.utils;

import android.content.Context;
import android.content.res.Resources;

public class AppUtils {

    private static Context mContext;

    public static void init(Context context) { //在Application中初始化
        mContext = context;
    }

    public static Context getAppContext() {
        return mContext;
    }

    public static Resources getResource() {
        return mContext.getResources();
    }

}
