package com.gbq.model.listener;

import com.gbq.dto.ServerData;

/**
 * 用于接收返回的数据
 * Created by gbq on 2016-9-22.
 */
public interface GetDataListener {
    void getDataForNetWork(ServerData data);
}
