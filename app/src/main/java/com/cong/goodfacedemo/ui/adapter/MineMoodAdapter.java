package com.cong.goodfacedemo.ui.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cong.goodfacedemo.R;
import com.cong.goodfacedemo.base.BaseVH;
import com.cong.goodfacedemo.model.MoodBean;
import com.cong.goodfacedemo.utils.Util;


public class MineMoodAdapter extends BaseQuickAdapter<MoodBean, BaseVH> {

    public MineMoodAdapter() {
        super(R.layout.item_mood);
    }

    @Override
    protected void convert(BaseVH helper, MoodBean item) {
        helper.setImageUrl(R.id.iv_mood,item.getImageUrl());
        helper.setText(R.id.tv_mood_content,item.getContent());
        Util.setRound(helper.itemView,Util.dp2px(6));
    }
}
