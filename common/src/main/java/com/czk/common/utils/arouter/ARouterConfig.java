package com.czk.common.utils.arouter;

/**
 * 路由路径
 * 路径最少两级 /xx/xxx
 * create by : czk
 * date : 2019-09-1716:20
 */
public interface ARouterConfig {

    /*------------------------ app ----------------------------*/

    String APP_MAIN_ACTIVITY = "/app/MainActivity";


    /*------------------------moudle one----------------------------*/
    /**
     *  电商首页
     */
    String KN_MAIN_ACTIVITY = "/kn/KnowledgeActivity";


    /*------------------------moudle demo----------------------------*/

    /**
     * 用户模块
     */
    String USER_MAIN_ACTIVITY = "/user/UserActivity";


    /*---------------------------- 用来测试的一下页面----------------------*/
    /**
     * 练习constraintlayout布局
     */
    String USER_TEST_CONSTRAINT_ACTIVITY = "/user/TestConstriantLayoutActivity";

    /**
     * 练习Aidl的使用
     */
    String Demo_TEST_CONSTRAINT_ACTIVITY = "/user/TestAidlActivity";



}

