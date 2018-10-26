package com.bihucj.mcandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by 孟晨 on 2018/10/26.
 */

public class OtherUtils {

    /**
     * 跳转工具类
     */
    public static class IntentUtils {
        public static void startAct(Context c1, Class<?> c2, boolean needFinish) {
            c1.startActivity(new Intent(c1, c2));
            if (needFinish) ((Activity) c1).finish();
        }

        public static void startExtraAct(Context c1, Class<?> c2, @NonNull String key, Object value) {
            Intent intent = new Intent(c1, c2);
            if (value instanceof String) {
                intent.putExtra(key, (String) value);
            } else if (value instanceof Integer) {
                intent.putExtra(key, (int) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(key, (boolean) value);
            } else {
                intent.putExtra(key, value.toString());
            }
            c1.startActivity(intent);
        }

        public static void startBundleAct(Context c1, Class<?> c2, Bundle b) {
            Intent intent = new Intent(c1, c2);
            intent.putExtras(b);
            c1.startActivity(intent);
        }
    }


}
