package com.gbq.model.impl;

import com.gbq.model.listener.GetDataListener;

/**
 * 网络数据行为接口
 * Created by gbq on 2016-9-22.
 */
public interface INetWork {
    void getMainData(GetDataListener listener);

    String getOneData();

    String getTwoData();
}
