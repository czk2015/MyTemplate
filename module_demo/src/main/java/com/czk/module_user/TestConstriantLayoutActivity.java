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
@Route(path = ARouterConfig.USER_TEST_CONSTRAINT_ACTIVITY)
public class TestConstriantLayoutActivity extends BaseActivity {

    @Override
    public int setContentView() {
        return R.layout.user_activity_test_constraint;
    }

}
