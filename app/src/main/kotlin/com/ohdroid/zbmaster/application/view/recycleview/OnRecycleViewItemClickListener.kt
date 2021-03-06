package com.ohdroid.zbmaster.application.view.recycleview

import android.view.View

/**
 * Created by ohdroid on 2016/4/5.
 */
interface OnRecycleViewItemClickListener {

    /**
     * 当recycleview item被点击后回掉
     * @param view 点击的view
     * @param position 点击的位置
     */
    fun onItemClick(view: View, position: Int)
}