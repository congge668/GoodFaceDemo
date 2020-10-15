package com.cong.goodfacedemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.cong.goodfacedemo.R;
import com.cong.goodfacedemo.model.MoodBean;
import com.cong.goodfacedemo.ui.adapter.MineMoodAdapter;
import com.cong.goodfacedemo.ui.widget.SGridLayoutManagerWrapper;
import com.cong.goodfacedemo.ui.widget.SpaceItemDecoration;
import com.cong.goodfacedemo.utils.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MoodFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.rv_mood)
    RecyclerView rvMood;



    public static MoodFragment newInstance() {

        Bundle args = new Bundle();

        MoodFragment fragment = new MoodFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_mood, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvMood.setLayoutManager(new SGridLayoutManagerWrapper(2, LinearLayoutManager.VERTICAL));
        rvMood.addItemDecoration(new SpaceItemDecoration(getContext(), Util.dp2px(8)));
        //rvMood.setBackgroundColor(getResources().getColor(R.color.color_f2f2f7));

        String imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1602589688541&di=4c43e797c0b66c0eea9aba4fd6e1e3b1&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160410%2Fda0428f4f56d4af48009b115ab8fbb3b_th.jpg";
        //本地模拟数据
        List<MoodBean> moodBeans = new ArrayList<>();
        moodBeans.add(new MoodBean(imageUrl,"早餐3元，中晚餐各15元一餐，一日三餐36元，一个月1080元。"));
        moodBeans.add(new MoodBean(imageUrl,"房租250元加水电费100元，每个月350元。因为租的房子在七楼、没电梯、没阳台、光线太暗，所以房租比较便宜"));
        moodBeans.add(new MoodBean(imageUrl,"话费每月100元"));
        moodBeans.add(new MoodBean(imageUrl,"十年如一日的不止是爱情，还有我们的工资。房价和物价一年比一年高，一年比一年涨的快，唯独工资原地踏步。普通人想在城市拥有一套属于自己的房子，比登天还难"));
        moodBeans.add(new MoodBean(imageUrl,"早餐3元，中晚餐各15元一餐，一日三餐36元，一个月1080元。"));
        moodBeans.add(new MoodBean(imageUrl,"房租250元加水电费100元，每个月350元。因为租的房子在七楼、没电梯、没阳台、光线太暗，所以房租比较便宜"));
        moodBeans.add(new MoodBean(imageUrl,"话费每月100元"));
        MineMoodAdapter adapter = new MineMoodAdapter();
        rvMood.setAdapter(adapter);
        adapter.setNewData(moodBeans);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
