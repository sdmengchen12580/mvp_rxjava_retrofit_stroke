package com.bihucj.mcandroid.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bihucj.mcandroid.R;
import com.bihucj.mcandroid.adapter.GetHomeDateAdapter;
import com.bihucj.mcandroid.base.baseui.BaseMvpActivity;
import com.bihucj.mcandroid.http.main.bean.GetGoodsVarietyCodesBean;
import com.bihucj.mcandroid.mvp.mainmvp.MainCompany.IMainView;
import com.bihucj.mcandroid.mvp.mainmvp.MainPresenter;
import com.bihucj.mcandroid.utils.ToastUtils;
import com.bihucj.mcandroid.weight.dialog.LoadDialog;
import com.bihucj.mcandroid.weight.refesh.CustomRefreshFooter;
import com.bihucj.mcandroid.weight.refesh.CustomRefreshHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.bihucj.mcandroid.R.style.translatedialog;

public class HomeActivity extends BaseMvpActivity<IMainView, MainPresenter<IMainView>> implements IMainView {

    @BindView(R.id.rv_date)
    RecyclerView rvDate;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    private GetHomeDateAdapter getHomeDateAdapter;

    @Override
    protected int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        //rv
        rvDate.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        //刷新
        smartRefreshLayout.setRefreshHeader(new CustomRefreshHeader(HomeActivity.this));
        smartRefreshLayout.setRefreshFooter(new CustomRefreshFooter(HomeActivity.this));
        smartRefreshLayout.setEnableScrollContentWhenLoaded(true);//是否在加载完成时滚动列表显示新的内容
        smartRefreshLayout.setDisableContentWhenLoading(false);
        smartRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                selfPresenter.getDate(true);
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshlayout.finishRefresh();
                        refreshlayout.setLoadmoreFinished(false);//恢复上拉状态
                        refreshlayout.setEnableLoadmore(true); //可以加载更多
                    }
                }, 1000);
            }

            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        selfPresenter.getDate(false);
                        refreshlayout.finishLoadmore();
                    }
                }, 1000);
            }
        });
    }

    @Override
    protected void initDate() {
        selfPresenter.getDate(true);
    }

    //告知BaseActivity你的业务类
    @Override
    public MainPresenter<IMainView> choicePresenter() {
        return new MainPresenter<>();
    }

    //手动p m层解绑
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
    public void showNullView() {
        LoadDialog.getInstance(HomeActivity.this, translatedialog).closeDialog();
        smartRefreshLayout.setEnableLoadmore(false);
        smartRefreshLayout.setEnableRefresh(false);
        rvDate.setVisibility(View.GONE);
        smartRefreshLayout.setVisibility(View.GONE);
        findViewById(R.id.request_date_null_layout).setVisibility(View.VISIBLE);
    }

    @Override
    public void showDate(GetGoodsVarietyCodesBean date, boolean isRefresh) {
        LoadDialog.getInstance(HomeActivity.this, translatedialog).closeDialog();
        //无数据-不用加载更多
        int dateCount = date.getData().getResponse().getRows().size();
        //后台分页接口返回数据为0-10
        if (dateCount < 10) {
            smartRefreshLayout.setEnableLoadmore(false);
        }
        //数据
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dateCount; i++) {
            list.add(date.getData().getResponse().getRows().get(i).getCodeName());
        }
        //首次直接加载date 不管isRefresh
        if (getHomeDateAdapter == null) {
            getHomeDateAdapter = new GetHomeDateAdapter(HomeActivity.this, list);
            rvDate.setAdapter(getHomeDateAdapter);
            return;
        }
        //非首次的刷新  or  加载
        if (isRefresh) {
            getHomeDateAdapter.refreshData(list);
        } else {
            getHomeDateAdapter.addBottomData(list);
        }
    }

    @Override
    public void showFail(String errorMsg) {
        LoadDialog.getInstance(HomeActivity.this, translatedialog).closeDialog();
        ToastUtils.show(errorMsg);
    }
}