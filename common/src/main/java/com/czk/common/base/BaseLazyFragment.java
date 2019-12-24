package com.czk.common.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;

/**
 * 数据懒加载方式
 * 原理：
 * 1、该页面是否首次加载(当数据加载完成之后，置反)
 * 2、页面是否可见
 * 3、控件是否初始化完成(view的初始化虽然实在onCreateview方法中进行的但是在该发放中记录变量的话不一定准确，根据生命周期来看，onActivityCreated 在它之后执行所以放在它里面记录变量比较准确)
 * create by czk at 2019-10-14
 */
public abstract class BaseLazyFragment extends BaseFragment {

    private boolean isFirst = true;//页面中的数据是否是第一次加载
    private boolean isPrepared = false; //view初始化是否完成

    /**
     * 页面是否可见
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getUserVisibleHint()) {
            setUserVisibleHint(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        resetState();
    }

    private void lazyLoad() {
        if (!isFirst || !isPrepared) {
            return;
        }
        isFirst = false;
        initData();
    }

    private void resetState() {
        isFirst = true;
        isPrepared = false;
    }

    protected abstract void initData();

}
