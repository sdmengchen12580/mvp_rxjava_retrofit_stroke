package com.bihucj.mcandroid.model;

import com.bihucj.mcandroid.entity.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孟晨 on 2018/9/19.
 */

public class IModelDate implements ModelDate {

    @Override
    public void loadDate(LoadDateListener loadDateListener) {
        List<Date> list = new ArrayList<>();
        list.add(new Date("sada"));
        list.add(new Date("sada"));
        list.add(new Date("sada"));
        list.add(new Date("sada"));
        list.add(new Date("sada"));
        list.add(new Date("sada"));
        list.add(new Date("sada"));
        loadDateListener.complete(list);
    }
}
