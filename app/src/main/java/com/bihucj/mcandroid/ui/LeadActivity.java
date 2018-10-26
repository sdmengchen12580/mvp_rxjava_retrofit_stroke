package com.bihucj.mcandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bihucj.mcandroid.R;
import com.bihucj.mcandroid.custom.Config;
import com.bihucj.mcandroid.utils.OtherUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class LeadActivity extends AppCompatActivity {

    //返回 clear timer
    private CompositeSubscription comp;
    private Subscription sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        comp = new CompositeSubscription();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sub = Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        OtherUtils.IntentUtils.startAct(LeadActivity.this, HomeActivity.class, true);
                    }
                });
        comp.add(sub);
    }

    @Override
    protected void onPause() {
        comp.clear();
        super.onPause();
    }
}
