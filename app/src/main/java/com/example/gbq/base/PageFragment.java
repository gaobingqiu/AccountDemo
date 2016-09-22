package com.example.gbq.base;


import android.support.v4.app.Fragment;

import com.example.gbq.dto.ServerData;

/**
 * Created by gbq on 2016-9-22.
 */
public abstract class PageFragment extends Fragment {
    /*通常需要载入*/
    @Override
    public void onResume() {
        super.onResume();
        refreshView();
    }

    public abstract void refreshView();


    /**
     * Activity 供Fragment回调的接口
     */
    public interface IMainCallBack{
        /*取得Fragment共用的数据*/
        ServerData getCommonData();
        /*要求Fragment刷新数据*/
        void refreshCommonData();

    }
}
