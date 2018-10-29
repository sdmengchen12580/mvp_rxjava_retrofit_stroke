package com.bihucj.mcandroid.base.baseui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.bihucj.mcandroid.base.basemvp.BasePresenter;
import com.bihucj.mcandroid.utils.ViewManager;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 孟晨 on 2018/9/19.
 */

//V是接口-T是要用到的业务类
public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    public T selfPresenter;
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewManager.getInstance().addActivity(this);
        selfPresenter = choicePresenter();        //选择自己业务类
        selfPresenter.attachView((V) this);        //基类绑定接口
        setContentView(getViewId());
        unbinder = ButterKnife.bind(this);
        initView(savedInstanceState);
        initDate();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        selfPresenter.disAttchView();        //v p 层解绑
        super.onDestroy();
    }

    protected abstract T choicePresenter();

    protected abstract int getViewId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initDate();
}
