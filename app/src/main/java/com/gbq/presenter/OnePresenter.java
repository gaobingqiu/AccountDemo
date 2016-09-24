package com.gbq.presenter;

import com.gbq.fragment.impl.IOneFView;
import com.gbq.model.impl.INetWork;
import com.gbq.model.NetWork;
import com.gbq.presenter.impl.IOneFPresenter;

/**
 * 综合新闻列表的行为者
 * Created by gbq on 2016-9-22.
 */
public class OnePresenter implements IOneFPresenter {
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
