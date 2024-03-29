package com.czk.moudle_knowledge;

import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.czk.common.BaseActivity;
import com.czk.common.utils.arouter.ARouterConfig;
import com.czk.common.utils.arouter.ARouterUtils;

import butterknife.OnClick;

/**
 * create by : czk
 * date : 2019-09-1717:53
 */
@Route(path = ARouterConfig.KN_MAIN_ACTIVITY)
public class KnowledgeActivity extends BaseActivity {

    @Override
    public int setContentView() {
        return R.layout.kn_activity_knowledge;
    }

    @OnClick({R2.id.kn_tv_bakc})
    public void viewClick(View v) {
        int id = v.getId();
        if(id==R.id.kn_tv_bakc){
            ARouterUtils.intentTo(ARouterConfig.APP_MAIN_ACTIVITY);
            finish();
        }else{
            Toast.makeText(this,"没找到id",Toast.LENGTH_SHORT).show();
        }
    }

}
