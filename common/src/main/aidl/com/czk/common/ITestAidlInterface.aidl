// ITestAidlInterface.aidl
package com.czk.common;
import com.czk.common.TestAidlBean;
// Declare any non-default types here with import statements

interface ITestAidlInterface {
    //普通方法
    void normalMethod();
    //获取数去列表
    List<TestAidlBean> getBeanlist();
    //定向tag
    void insertOneInOut(inout TestAidlBean bean);
    void insertOneIn(in TestAidlBean bean);
    void insertOneOut(out TestAidlBean bean);

    //in    数据只能由客户端传向服务端，服务端对数据的修改不会影响到客户端
    //out   数据只能由服务端传向客户端，即使客户端向方法接口传入了一个对象，该对象中的属性值也是为空的，即不包含任何数据，服务端获取到该对象后，对该对象的任何操作，就会同步到客户端这边
    //inout 数据可在服务端与客户端之间双向流通
}
