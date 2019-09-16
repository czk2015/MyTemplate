package com.czk.mytemplate.wxapi;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {
    // IWXAPI 是第三方app和微信通信的openapi接口
    private IWXAPI api;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, "WX_APP_ID", false);
        api.registerApp("WX_APP_ID");

        api.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.errCode == BaseResp.ErrCode.ERR_OK) {
            //分享成功
//            Toast.makeText(this, "微信分享成功", Toast.LENGTH_SHORT).show();
        } else {
            //非正常返回,分享失败
            Toast.makeText(this, "微信分享失败", Toast.LENGTH_SHORT).show();
        }

        this.finish();
    }
}
