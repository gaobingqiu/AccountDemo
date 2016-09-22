package com.example.gbq.accountdemo;

import com.example.gbq.dto.ServerData;

/**
 * Created by gbq on 2016-9-22.
 */
public interface IMainAView {
    void setServerData(ServerData data);

    boolean showLoading();

    void hideLoading();
}
