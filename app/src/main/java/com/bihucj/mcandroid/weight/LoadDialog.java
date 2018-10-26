package com.bihucj.mcandroid.weight;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bihucj.mcandroid.R;

import static com.bihucj.mcandroid.R.style.translatedialog;


/**
 * Created by 孟晨 on 2018/5/26.
 */

public class LoadDialog extends Dialog {

    private static LoadDialog singleton = null;

    public static LoadDialog getInstance(@NonNull Context context, @StyleRes int themeResId) {
        if (singleton == null) {
            synchronized (LoadDialog.class) {
                if (singleton == null) {
                    singleton = new LoadDialog(context, themeResId);
                }
            }
        }
        return singleton;
    }


    public LoadDialog(@NonNull Context context) {
        super(context);
    }

    public LoadDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected LoadDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private TextView textView;
    private ProgressBar progressBar;
    private ObjectAnimator mCircleAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loaddialog_layout);
        setCanceledOnTouchOutside(false);
        textView = findViewById(R.id.tv_dialog);
        progressBar = findViewById(R.id.progress);
        initAnimal();
    }

    private void initAnimal() {
        mCircleAnimator = ObjectAnimator.ofFloat(progressBar, "rotation", 0.0f, 360.0f);
        mCircleAnimator.setDuration(60000);
        mCircleAnimator.setInterpolator(new LinearInterpolator());
        mCircleAnimator.setRepeatCount(-1);
        mCircleAnimator.setRepeatMode(ObjectAnimator.RESTART);
    }

    public void startDialog(String textContent) {
        textView.setText(textContent);
        mCircleAnimator.start();
    }

    public void closeDialog() {
        if (mCircleAnimator != null) {
            mCircleAnimator.end();
            mCircleAnimator = null;
        }
        if (isShowing()) {
            this.hide();
            this.dismiss();
        }
    }
}
