package com.bihucj.mcandroid.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bihucj.mcandroid.base.baseui.BaseActivity;
import com.bihucj.mcandroid.http.main.bean.GetGoodsVarietyCodesBean;
import com.bihucj.mcandroid.R;
import com.bihucj.mcandroid.mvp.Presenter.MainPresenter;
import com.bihucj.mcandroid.mvp.view.IDateView;

import static com.bihucj.mcandroid.R.style.translatedialog;

import com.bihucj.mcandroid.utils.ToastUtils;
import com.bihucj.mcandroid.weight.LoadDialog;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<IDateView, MainPresenter<IDateView>> implements IDateView {


    //FIXME 1.先知道ui界面需要定义什么接口  如IDateView
    //FIXME 2.写自己业务类 MainPresenter，由于封装到BaseActivity，只需要将本activity的choicePresenter()填入你的业务类
    //FIXME 3.想model数据层，定义接口ModelDate，获取数据。通过ModelDate实现类去请求数据，以及结果的返回给业务层
    //FIXME 4.业务层通过接口IDateView，通知更新UI

    //FIXME:解释：
    //FIXME 5.IModelDate中选择将数据通过接口的形式返回，是为了不让P层等待，数据好了立即通知，及可。如果用return将数据返回就会等待
    //FIXME 6.解绑：v和p层解绑在BaseActivity，p层和m层解绑，在activity的onStop
    @Override
    protected int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    }

    @Override
    protected void initDate() {
        selfPresenter.getDate();
    }

    //告知BaseActivity你的业务类
    @Override
    public MainPresenter<IDateView> choicePresenter() {
        return new MainPresenter<>();
    }

    @Override
    protected void onStop() {
        super.onStop();
        selfPresenter.cancelSub();
    }

    //------------------------------------你业务展示定义的接口------------------------------------
    @Override
    public void showLoading() {
        LoadDialog.getInstance(HomeActivity.this, translatedialog).show();
        LoadDialog.getInstance(HomeActivity.this, translatedialog).startDialog("加载数据中");
    }

    @Override
    public void showDate(GetGoodsVarietyCodesBean date) {
        LoadDialog.getInstance(HomeActivity.this, translatedialog).closeDialog();
        //数据展示
        List<String> list = new ArrayList<>();
        for (int i = 0; i < date.getData().getResponse().getRows().size(); i++) {
            list.add(date.getData().getResponse().getRows().get(i).getCodeName());
        }
        ((ListView) findViewById(R.id.lv_date)).setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, list));
    }

    @Override
    public void showFail(String errorMsg) {
        LoadDialog.getInstance(HomeActivity.this, translatedialog).closeDialog();
        ToastUtils.show(errorMsg);
    }
}