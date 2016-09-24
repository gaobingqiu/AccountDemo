package com.gbq.presenter;

import com.gbq.fragment.impl.ITwoFView;
import com.gbq.model.impl.INetWork;
import com.gbq.model.NetWork;
import com.gbq.presenter.impl.ITwoFPresenter;

/**
 * 科技新闻Fragment的行为者
 * Created by gbq on 2016-9-22.
 */
public class TwoPresenter implements ITwoFPresenter {
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
