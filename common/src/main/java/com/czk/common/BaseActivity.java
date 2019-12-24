package com.czk.common;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * create by : czk
 * date : 2019-09-1716:30
 */
public abstract class BaseActivity extends AppCompatActivity {
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        unbinder=ButterKnife.bind(this);
        initData();
    }

    public abstract int setContentView();

    public void initData(){

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}
