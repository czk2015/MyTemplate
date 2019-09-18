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

    /*------------------------资讯----------------------------*/

    /*------------------------电商----------------------------*/
    /**
     *  电商首页
     */
    String KN_MAIN_ACTIVITY = "/kn/KnowledgeActivity";

    /*------------------------创投----------------------------*/

    /*------------------------用户中心----------------------------*/

    /**
     * 用户模块
     */
    String USER_MAIN_ACTIVITY = "/user/UserActivity";


}

