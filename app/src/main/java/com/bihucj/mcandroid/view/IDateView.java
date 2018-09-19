package com.bihucj.mcandroid.view;

import com.bihucj.mcandroid.entity.Date;
import java.util.List;

/**
 * Created by 孟晨 on 2018/9/19.
 */


//第一步：确定ui层需要哪些操控ui地方，定义成接口
public interface IDateView {

    void showLoading();

    void showDate(List<Date> list);
}
