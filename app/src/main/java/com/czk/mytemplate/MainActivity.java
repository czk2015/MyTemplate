package com.czk.mytemplate;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.czk.common.BaseActivity;
import com.czk.common.utils.arouter.ARouterConfig;
import com.czk.common.utils.arouter.ARouterUtils;

import butterknife.OnClick;

/**
 * 首页
 * create by : czk
 * date : 2019-09-1716:49
 */
@Route(path = ARouterConfig.APP_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.tv_turn_to,R.id.tv_turn_to2})
    public void ViewClick(View v) {
        switch (v.getId()) {
            case R.id.tv_turn_to:
                ARouterUtils.intentTo(ARouterConfig.USER_MAIN_ACTIVITY);
                finish();
                break;
            case R.id.tv_turn_to2:
                ARouterUtils.intentTo(ARouterConfig.KN_MAIN_ACTIVITY);
                finish();
                break;
            default:
                break;
        }
    }

}
