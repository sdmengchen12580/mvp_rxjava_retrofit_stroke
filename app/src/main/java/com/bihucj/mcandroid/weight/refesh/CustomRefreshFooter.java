package com.bihucj.mcandroid.weight.refesh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bihucj.mcandroid.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/**
 * Created by solo on 2018/2/1.
 * SmartRefreshLayout的自定义Footer
 */

public class CustomRefreshFooter extends LinearLayout implements RefreshFooter {
    private ImageView mImage;
    private AnimationDrawable pullDownAnim;
    private View view;
    private boolean hasSetPullDownAnim = false;
    private boolean hasSetHHDownAnim = false;
    public CustomRefreshFooter(Context context) {
        super(context);
        view = View.inflate(context, R.layout.widget_custom_refresh_footer, this);
        mImage = (ImageView) view.findViewById(R.id.iv_refresh_footer);
    }

    @Override
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {
        view.setVisibility(VISIBLE);
        float  per=1;
        // 下拉的百分比小于100%时，不断调用 setScale 方法改变图片大小
        if (percent < 1) {
            mImage.setImageResource(R.drawable.meimei_showing);
            pullDownAnim = (AnimationDrawable) mImage.getDrawable();
            pullDownAnim.start();

            mImage.setScaleX(per);
            mImage.setScaleY(per);

            //是否执行过翻跟头动画的标记
            if (hasSetPullDownAnim) {
                hasSetPullDownAnim = false;
            }
        }

        //当下拉的高度达到Header高度100%时，开始加载正在下拉的初始动画，即翻跟头
        if (percent >= 1) {
            //因为这个方法是不停调用的，防止重复
            if (!hasSetPullDownAnim) {
                mImage.setImageResource(R.drawable.meimei_showing);
                pullDownAnim = (AnimationDrawable) mImage.getDrawable();
                pullDownAnim.start();

                hasSetPullDownAnim = true;
            }
        }
    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {
        view.setVisibility(VISIBLE);


        float  per=1;
        // 下拉的百分比小于100%时，不断调用 setScale 方法改变图片大小
        if (percent < 1) {
            mImage.setImageResource(R.drawable.meimei_showing);
            pullDownAnim = (AnimationDrawable) mImage.getDrawable();
            pullDownAnim.start();

            mImage.setScaleX(per);
            mImage.setScaleY(per);

            //是否执行过翻跟头动画的标记
            if (hasSetHHDownAnim) {
                hasSetHHDownAnim = false;
            }
        }

        //当下拉的高度达到Header高度100%时，开始加载正在下拉的初始动画，即翻跟头
        if (percent >= 0.1) {
            //因为这个方法是不停调用的，防止重复
            if (!hasSetHHDownAnim) {
                mImage.setImageResource(R.drawable.meimei_showing);
                pullDownAnim = (AnimationDrawable) mImage.getDrawable();
                pullDownAnim.start();

                hasSetHHDownAnim = true;
            }
        }
    }

    @Override
    public void onLoadmoreReleased(RefreshLayout layout, int footerHeight, int extendHeight) {
        view.setVisibility(VISIBLE);
    }

    @Override
    public boolean setLoadmoreFinished(boolean finished) {

        return false;
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {

    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        // 结束动画
        if (pullDownAnim != null && pullDownAnim.isRunning()) {
            pullDownAnim.stop();
        }
        view.setVisibility(GONE);
        //重置状态
        hasSetPullDownAnim = false;
        hasSetHHDownAnim=false;
        return 0;
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {

            case ReleaseToRefresh:

                break;
        }
    }
}
