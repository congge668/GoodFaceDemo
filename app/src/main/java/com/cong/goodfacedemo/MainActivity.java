package com.cong.goodfacedemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import com.cong.goodfacedemo.ui.adapter.MinePageAdapter;
import com.cong.goodfacedemo.ui.fragment.MineGiftFragment;
import com.cong.goodfacedemo.ui.fragment.MoodFragment;
import com.cong.goodfacedemo.utils.GlideUtils;
import com.cong.goodfacedemo.utils.ShapeUtils;
import com.cong.goodfacedemo.utils.TvUtils;
import com.cong.goodfacedemo.utils.Util;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.v_top_bg)
    View vTopBg;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.iv_edit)
    ImageView ivEdit;
    @BindView(R.id.tv_tag_constellation)
    TextView tvTagConstellation;
    @BindView(R.id.tv_tag_address)
    TextView tvTagAddress;
    @BindView(R.id.tv_tag_sex)
    TextView tvTagSex;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.iv_user_head)
    ImageView ivUserHead;
    @BindView(R.id.tv_user_id)
    TextView tvUserId;
    @BindView(R.id.cardview_id)
    CardView cardviewId;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_slogan)
    TextView tvUserSlogan;
    @BindView(R.id.tv_yan_dou)
    TextView tvYanDou;
    @BindView(R.id.tv_cash_out)
    TextView tvCashOut;
    @BindView(R.id.cl_cash_out)
    ConstraintLayout clCashOut;
    @BindView(R.id.tv_lizhuan)
    TextView tvLizhuan;
    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    @BindView(R.id.cl_recharge)
    ConstraintLayout clRecharge;
    @BindView(R.id.cl_info_bg)
    ConstraintLayout clInfoBg;
    @BindView(R.id.fl_user_head)
    FrameLayout flUserHead;
    @BindView(R.id.view_line_1)
    View viewLine1;
    @BindView(R.id.tv_user_auth)
    TextView tvUserAuth;
    @BindView(R.id.stl_vp)
    SlidingTabLayout stlVp;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    //    @BindView(R.id.cl_user_show)
//    ConstraintLayout clUserShow;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;


    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        ButterKnife.bind(this);
        mContext = this;
        flContent.setBackgroundColor(Color.rgb(245, 245, 245));
        ShapeUtils.setShapeGradientTopLToBottomR(vTopBg, new int[]{Color.rgb(255, 122, 107), Color.rgb(255, 85, 140)});
        //头像
        GlideUtils.loadCircleImage(ivUserHead, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1602589688541&di=4c43e797c0b66c0eea9aba4fd6e1e3b1&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160410%2Fda0428f4f56d4af48009b115ab8fbb3b_th.jpg");
        //颜豆
        TvUtils.create().addSsb("100 ").addSsb(getString(R.string.yan_dou), Util.dp2px(12), mContext.getResources().getColor(R.color.color_99)).showIn(tvYanDou);
        ShapeUtils.setShapeCorner2Color(clInfoBg, getResources().getColor(R.color.white), Util.dp2px(16));
        ShapeUtils.setShapeCorner2Color(tvCashOut, Color.rgb(255, 122, 107), Util.dp2px(30));
        //礼钻
        TvUtils.create().addSsb("100 ").addSsb(getString(R.string.li_zuan), Util.dp2px(12), mContext.getResources().getColor(R.color.color_99)).showIn(tvLizhuan);
        ShapeUtils.setShapeCorner2Color(tvRecharge, Color.rgb(255, 85, 140), Util.dp2px(30));
        ShapeUtils.setShapeCorner2Color(tvUserAuth, getResources().getColor(R.color.white), Util.dp2px(16));

        //动态，收礼，送礼
        //ShapeUtils.setShapeCorner2Color(clUserShow, getResources().getColor(R.color.white), Util.dp2px(16));
        viewPager.setAdapter(new MinePageAdapter(getSupportFragmentManager(), Arrays.asList(MoodFragment.newInstance(), MineGiftFragment.newInstance(1), MineGiftFragment.newInstance(2)),
                Arrays.asList(getString(R.string.mood), getString(R.string.receiver_gift), getString(R.string.send_gift))));
        stlVp.setViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
        setStlTitle(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setStlTitle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //刷新处理
        //不允许上拉加载更多
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                //模拟请求数据
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh(true);
                    }
                }, 1000);

            }
        });

        //关键
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                refreshLayout.setEnabled(verticalOffset >=0);
            }
        });

    }

    private void setStlTitle(int position) {
        for (int x = 0; x < stlVp.getTabCount(); x++) {
            if (x == position) {
                stlVp.getTitleView(x).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                stlVp.getTitleView(x).setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            } else {
                stlVp.getTitleView(x).setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                stlVp.getTitleView(x).setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            }
        }

    }
}
