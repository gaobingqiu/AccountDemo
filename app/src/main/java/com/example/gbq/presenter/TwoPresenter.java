package com.example.gbq.presenter;

import com.example.gbq.fragment.ITwoFView;
import com.example.gbq.model.INetWork;
import com.example.gbq.model.NetWork;

/**
 * Created by gbq on 2016-9-22.
 */
public class TwoPresenter implements ITwoFPresenter{
    private INetWork netWork;
    private ITwoFView twoFragment;

    public TwoPresenter(ITwoFView twoFragment){
        this.twoFragment = twoFragment;
        netWork = new NetWork();
    }

    /*view 调用 P方法
    * 模拟从数据库获取数据
    * */
    @Override
    public void getSQLiteData(){
        twoFragment.showToast(netWork.getTwoData());
    }
}
