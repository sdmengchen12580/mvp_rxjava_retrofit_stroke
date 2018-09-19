package com.bihucj.mcandroid.model;

import com.bihucj.mcandroid.entity.Date;

import java.util.List;

/**
 * Created by 孟晨 on 2018/9/19.
 */

public interface ModelDate {

    void loadDate(LoadDateListener loadDateListener);

    interface LoadDateListener {
        void complete(List<Date> list);
    }
}
