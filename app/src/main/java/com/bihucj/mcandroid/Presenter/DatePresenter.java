package com.bihucj.mcandroid.Presenter;

import com.bihucj.mcandroid.entity.Date;
import com.bihucj.mcandroid.model.IModelDate;
import com.bihucj.mcandroid.view.IDateView;
import java.util.List;

/**
 * Created by 孟晨 on 2018/9/19.
 */


public class DatePresenter<T extends IDateView> extends BasePresenter<T>{

    IModelDate iModelDate = new IModelDate();

    public DatePresenter() {

    }

    public void getDate() {
        if (reference.get() != null) {
            //显示弹窗
            reference.get().showLoading();
            if (iModelDate != null) {
                iModelDate.loadDate(new IModelDate.LoadDateListener() {
                    @Override
                    public void complete(List<Date> list) {
                        if (reference.get() != null) {
                            reference.get().showDate(list);
                        }
                    }
                });
            }
        }
    }
}
