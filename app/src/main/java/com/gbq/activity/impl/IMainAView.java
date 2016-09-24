package com.gbq.activity.impl;

import com.gbq.dto.ServerData;

/**
 * Created by gbq on 2016-9-22.
 */
public interface IMainAView {
    void setServerData(ServerData data);

    boolean showLoading();

    void hideLoading();
}
