package com.bihucj.mcandroid.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bihucj.mcandroid.Presenter.DatePresenter;
import com.bihucj.mcandroid.R;
import com.bihucj.mcandroid.entity.Date;
import com.bihucj.mcandroid.ui.base.BaseActivity;
import com.bihucj.mcandroid.view.IDateView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends BaseActivity<IDateView, DatePresenter<IDateView>> implements IDateView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //date
        selfPresenter.getDate();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "开始获取数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDate(List<Date> list) {
        ListView lv_date = (ListView) findViewById(R.id.lv_date);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv_date.setAdapter(adapter);
    }

    @Override
    public DatePresenter<IDateView> choicePresenter() {
        return new DatePresenter<>();
    }
}