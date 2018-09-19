package com.bihucj.mcandroid.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bihucj.mcandroid.Presenter.BasePresenter;

/**
 * Created by 孟晨 on 2018/9/19.
 */

//V是接口-T是要用到的业务类
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    public T selfPresenter;

    protected abstract T choicePresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //选择自己业务类
        selfPresenter = choicePresenter();
        //基类绑定接口
        selfPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        selfPresenter.disAttchView();
    }
}
