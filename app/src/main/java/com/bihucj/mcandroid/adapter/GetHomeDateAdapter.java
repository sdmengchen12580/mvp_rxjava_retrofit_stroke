package com.bihucj.mcandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bihucj.mcandroid.R;
import com.bihucj.mcandroid.utils.OtherUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 孟晨 on 2018/10/26.
 */

public class GetHomeDateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mList = new ArrayList<>();
    private Context context;

    public GetHomeDateAdapter(Context context, List<String> list) {
        this.context = context;
        this.mList = list;
    }

    public void clearData() {
        if (mList.size() > 0 && mList != null) {
            mList.clear();
            notifyDataSetChanged();
        }
    }

    public void addBottomData(List<String> list) {
        if (list.size() > 0 && list != null) {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void refreshData(List<String> list) {
        if (list.size() > 0 && mList != null) {
            mList.clear();
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getListSize() {
        return mList.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.singleitem_text_date, null);
        return new ImgsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        if (holder instanceof ImgsViewHolder) {
            String content = mList.get(position);
            TextView tv_text = ((ImgsViewHolder) holder).tv_text;
            tv_text.setText(content);
        }
    }


    @Override
    public int getItemCount() {
        return (mList == null) ? 0 : mList.size();
    }


    private class ImgsViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_text;
        private LinearLayout ll_item;

        public ImgsViewHolder(View itemView) {
            super(itemView);
            tv_text = itemView.findViewById(R.id.tv_text);
            ll_item = itemView.findViewById(R.id.ll_item);
            ll_item.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    (int) OtherUtils.DensityUtil.dip2px(context, 50)));
        }
    }

    //-----------------------------------点击的接口----------------------------------------------
    private ClickItemCallback clickItemCallback;

    public interface ClickItemCallback {
        void clickAnalyse(String webTitle, String webUrl, String id, int position);
    }

    public void setOnItenClickCallBack(ClickItemCallback clickItemCallback) {
        this.clickItemCallback = clickItemCallback;
    }
}
