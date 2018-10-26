package org.lcsyjt.mylibrary.http.callback;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import rx.Subscriber;


public abstract class HttpListener<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        String errorMsg;
        if (e instanceof UnknownHostException) {
            errorMsg = "网络异常";
        } else if (e instanceof SocketTimeoutException) {
            errorMsg = "网络错误";
        } else {
            errorMsg = "网络错误";
        }
        onError(errorMsg);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    public abstract void onError(String errorMsg);

    public abstract void onSuccess(T t);
}
