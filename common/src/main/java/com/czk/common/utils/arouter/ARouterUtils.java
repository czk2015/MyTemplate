package com.czk.common.utils.arouter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.czk.common.BaseActivity;
import com.czk.common.base.BaseFragment;

/**
 * 路由工具类
 * create by : czk
 * date : 2019-09-1716:14
 */
public class ARouterUtils {

    /**
     * 根据path返回Fragment
     * @param path path
     * @return fragment
     */
    public static BaseFragment getFragment(String path) {
        return (BaseFragment) ARouter.getInstance()
                .build(path)
                .navigation();
    }

    /**
     * 根据path返回Activity
     * @param path path
     * @return Activity
     */
    public static BaseActivity getActivity(String path) {
        return (BaseActivity) ARouter.getInstance()
                .build(path)
                .navigation();
    }

    /**
     * 路由跳转
     * @param path
     */
    public static void intentTo(String path) {
       ARouter.getInstance().build(path).navigation();
    }


    /**
     * 路由跳转 - 页面切换动画
     * @param path
     */
    public static void intentToAnimate(String path) {
        ARouter.getInstance().build(path).navigation();
    }


}
