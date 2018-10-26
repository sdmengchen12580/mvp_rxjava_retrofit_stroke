package org.lcsyjt.mylibrary.http;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class OkHttpClientManager {

    private static OkHttpClientManager instance;

    private OkHttpClient okHttpClient;

    public static OkHttpClientManager getInstance() {
        if (instance == null) {
            synchronized (OkHttpClientManager.class) {
                if (instance == null) {
                    instance = new OkHttpClientManager();
                }
            }
        }
        return instance;
    }

    private OkHttpClientManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(HttpConfig.DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(HttpConfig.DEFAULT_WRITE_TIME, TimeUnit.SECONDS);
        builder.readTimeout(HttpConfig.DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);

//        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
//                .addHeaderParams("Connection", "close")
//                .build();
//        builder.addInterceptor(commonInterceptor);

        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("日志拦截器: ", message);
            }
        });
        loggingInterceptor.setLevel(level);
        builder.addInterceptor(loggingInterceptor);
        okHttpClient = builder.build();
    }

    OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
