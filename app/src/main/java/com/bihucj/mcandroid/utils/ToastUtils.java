package com.bihucj.mcandroid.utils;

import android.widget.Toast;


public class ToastUtils {

    public static Toast toast;

    public static void show(String text) {
        if (toast == null) {
            toast = Toast.makeText(AppUtils.getAppContext(),
                    text,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

}
