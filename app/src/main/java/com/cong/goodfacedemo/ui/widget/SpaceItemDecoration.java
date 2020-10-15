package com.cong.goodfacedemo.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;



public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private Context context;
    private int space; // 分隔线宽度
    private boolean isAllAround = false;  // 是否每个item 四周都要分隔线
    private boolean isCenterSpace = false; //只有中间有分割线
    private int columnNum;   //列数
    private boolean isTopSpace = false;

    public SpaceItemDecoration(Context context, int space) {
        this.context = context;
        this.space = space;
    }

    public SpaceItemDecoration(Context context, int space, boolean isTopSpace) {
        this.context = context;
        this.space = space;
        this.isTopSpace = isTopSpace;
    }

    public SpaceItemDecoration(boolean isAllAround, int space, int columnNum) {
        this.isAllAround = isAllAround;
        this.space = space;
        this.columnNum = columnNum;
    }

    /**
    * @desc :中间分割线
    * @author :congge on 2019/6/21 10:54
    **/
    public SpaceItemDecoration(int space, int columnNum, boolean isCenterSpace){
        this.isCenterSpace = isCenterSpace;
        this.space = space;
        this.columnNum = columnNum;
    }

    @Override
    public void getItemOffsets(final Rect outRect, final View view, RecyclerView parent, RecyclerView.State state) {
        if(isCenterSpace){
            if(columnNum >= 2){
                if(columnNum == 2){
                    //底部分割线，不是最后两个都设底部
                    if(!(parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount()-1 || parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount()-2)){
                        outRect.bottom = space;
                    }
                    // 设置左右分隔线
                    switch ((parent.getChildLayoutPosition(view) + 1) % columnNum) {
                        case 0:
                            //第二列
                            outRect.left = space / 2;
                            break;
                        case 1:
                            //第一列
                            outRect.right = space / 2;

                            break;

                    }
                }

            } else {
                if(parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount()-1){
                    outRect.bottom = space;
                }

            }

        } else if (isAllAround) {
            //每个item四面都有分隔线，先每个item底部分隔线
            outRect.bottom = space;
            //第一列的顶部设置分隔线
            if (parent.getChildLayoutPosition(view) < columnNum) {
                outRect.top = space;
            }
            // 设置左右分隔线
            switch ((parent.getChildLayoutPosition(view) + 1) % columnNum) {
                case 0:
                    //最后列item
                    outRect.right = space;
                    if (columnNum == 2) {
                        //二列item的分隔线设置
                        outRect.left = space / 2;
                    } else if (columnNum == 3) {
                        //三列item的分隔线设置
                        outRect.left = space / 3;
                    }
                    break;
                case 1:
                    //第一列item
                    outRect.left = space;
                    if (columnNum == 2) {
                        //二列item的分隔线设置
                        outRect.right = space / 2;
                    } else if (columnNum == 3) {
                        //三列item的分隔线设置
                        outRect.right = space / 3;
                    }
                    break;
                case 2:
                    //第二列item ，要有三列
                    outRect.left = 2 * space / 3;
                    outRect.right = 2 * space / 3;
                    break;
            }
        } else {

                StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();

                outRect.top = space;
                //第一列都为0，第二列都为1
                if (params.getSpanIndex() % 2 == 0) {
                    outRect.left = space;
                    outRect.right = space / 2;
                } else {
                    outRect.left = space / 2;
                    outRect.right = space;
                }

        }
    }




}
