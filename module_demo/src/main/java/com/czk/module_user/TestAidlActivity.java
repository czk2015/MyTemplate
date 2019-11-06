package com.czk.module_user;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.czk.common.BaseActivity;
import com.czk.common.ITestAidlInterface;
import com.czk.common.service.TestAdilService;
import com.czk.common.utils.arouter.ARouterConfig;


/**
 * create by : czk
 * date : 2019-09-1717:04
 */
@Route(path = ARouterConfig.Demo_TEST_CONSTRAINT_ACTIVITY)
public class TestAidlActivity extends BaseActivity{
    ITestAidlInterface iTestAidlInterface;
    ServiceConnection conn;

    @Override
    public int setContentView() {
        return R.layout.user_activity_test_constraint;
    }

    @Override
    public void initData() {
        super.initData();
        bindAidlService();
    }

    public void bindAidlService() {
        Intent intent = new Intent("com.czk.common.service.testaidlservice");
        intent.setPackage(getPackageName());
        conn = new MyConnect();
        bindService(intent,conn, Service.BIND_AUTO_CREATE);
    }

    public class MyConnect implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iTestAidlInterface =  ITestAidlInterface.Stub.asInterface(service);
            if(iTestAidlInterface!=null){
                try {
                    iTestAidlInterface.normalMethod();

                    Log.e("czk","列表数据--->"+ iTestAidlInterface.getBeanlist().size());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onBindingDied(ComponentName name) {

        }

        @Override
        public void onNullBinding(ComponentName name) {

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(conn!=null){
            unbindService(conn);
        }
    }
}
