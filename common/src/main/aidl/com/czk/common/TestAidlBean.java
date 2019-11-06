package com.czk.common;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * create by czk at 2019-11-05
 */
public class TestAidlBean implements Parcelable {
    public String name;
    public int age;
    public boolean isGirl;

    public TestAidlBean() {

    }

    protected TestAidlBean(Parcel in) {
        readFromParcel(in);
    }

    /**
     * 反序列化
     * @param in
     */
    public void readFromParcel(Parcel in){
        name = in.readString();
        age = in.readInt();
        isGirl = in.readByte() != 0;
    }

    /**
     * 序列化
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeByte((byte) (isGirl ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TestAidlBean> CREATOR = new Creator<TestAidlBean>() {
        @Override
        public TestAidlBean createFromParcel(Parcel in) {
            return new TestAidlBean(in);
        }

        @Override
        public TestAidlBean[] newArray(int size) {
            return new TestAidlBean[size];
        }
    };

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGirl() {
        return isGirl;
    }

    public void setGirl(boolean girl) {
        isGirl = girl;
    }
}
