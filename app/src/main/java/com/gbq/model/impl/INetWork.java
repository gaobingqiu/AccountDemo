package com.gbq.model.impl;

import com.gbq.model.listener.GetDataListener;

/**
 * Created by gbq on 2016-9-22.
 */
public interface INetWork {
    void getMainData(GetDataListener listener);

    String getOneData();

    String getTwoData();
}
