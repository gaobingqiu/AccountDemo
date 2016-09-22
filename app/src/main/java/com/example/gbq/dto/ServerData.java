package com.example.gbq.dto;

/**
 * Created by gbq on 2016-9-22.
 */
public class ServerData {
    private String oneData;
    private String twoData;

    public ServerData(String str1,String str2){
        oneData = str1;
        twoData = str2;
    }

    public String getOneData() {
        return oneData;
    }

    public void setOneData(String oneData) {
        this.oneData = oneData;
    }

    public String getTwoData() {
        return twoData;
    }

    public void setTwoData(String twoData) {
        this.twoData = twoData;
    }


}
