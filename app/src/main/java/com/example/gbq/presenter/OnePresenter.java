package com.example.gbq.presenter;

import com.example.gbq.fragment.IOneFView;
import com.example.gbq.model.INetWork;
import com.example.gbq.model.NetWork;

/**
 * Created by gbq on 2016-9-22.
 */
public class OnePresenter implements IOneFPresenter{
    private INetWork netWork;
    private IOneFView oneFragment;

    public OnePresenter(IOneFView oneFragment){
        this.oneFragment = oneFragment;
        netWork = new NetWork();
    }

    /*view 调用 P方法
    * 回调接口
    * m.get
    * */
    @Override
    public void getSQLiteData(){
        oneFragment.showToast(netWork.getOneData());

    }
}
