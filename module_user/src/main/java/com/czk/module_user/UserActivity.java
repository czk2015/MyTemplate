package com.czk.module_user;

import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.czk.common.BaseActivity;
import com.czk.common.utils.arouter.ARouterConfig;
import com.czk.common.utils.arouter.ARouterUtils;

import butterknife.OnClick;


/**
 * create by : czk
 * date : 2019-09-1717:04
 */
@Route(path = ARouterConfig.USER_MAIN_ACTIVITY)
public class UserActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_mian;
    }

    @OnClick({R2.id.user_tv_back})
    public void viewClick(View v) {
        int id = v.getId();
        if (id == R.id.user_tv_back) {
            ARouterUtils.intentTo(ARouterConfig.APP_MAIN_ACTIVITY);
            finish();
        } else {
            Toast.makeText(this, "没找到id", Toast.LENGTH_SHORT).show();
        }
    }

}
