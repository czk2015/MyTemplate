package com.czk.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.czk.common.ITestAidlInterface;
import com.czk.common.TestAidlBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create by czk at 2019-11-05
 */
public class TestAdilService extends Service {

    public List<TestAidlBean> list = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    public void initData(){
        TestAidlBean bean1 =new TestAidlBean();
        bean1.setName("张三");
        bean1.setAge(26);
        bean1.setGirl(false);
        list.add(bean1);

        TestAidlBean bean2 =new TestAidlBean();
        bean1.setName("李四");
        bean1.setAge(27);
        bean1.setGirl(false);
        list.add(bean2);

        TestAidlBean bean3 =new TestAidlBean();
        bean1.setName("王五");
        bean1.setAge(25);
        bean1.setGirl(true);
        list.add(bean3);
    }

    ITestAidlInterface.Stub stub = new ITestAidlInterface.Stub() {
        @Override
        public void normalMethod() throws RemoteException {
            Log.e("czk","连接开始了");
        }

        @Override
        public List<TestAidlBean> getBeanlist() throws RemoteException {
            return list;
        }

        @Override
        public void insertOneInOut(TestAidlBean bean) throws RemoteException {
            if(bean!=null){
                list.add(bean);
            }
        }

        @Override
        public void insertOneIn(TestAidlBean bean) throws RemoteException {

        }

        @Override
        public void insertOneOut(TestAidlBean bean) throws RemoteException {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}
