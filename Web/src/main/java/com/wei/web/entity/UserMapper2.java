package com.wei.web.entity;

import java.util.ArrayList;

public class UserMapper2 {
    private ArrayList<RegUser> userArr = new ArrayList<>();

    public UserMapper2() {
        userArr.add(new RegUser("zs","123","张三"));
        userArr.add(new RegUser("ls","456","李四"));
        userArr.add(new RegUser("ww","789","王五"));
    }

    public ArrayList getUserArr() {
        return userArr;
    }

}
