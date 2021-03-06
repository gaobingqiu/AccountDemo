package com.gbq.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gbq.accountdemo.R;
import com.gbq.base.PageFragment;
import com.gbq.dto.ServerData;
import com.gbq.fragment.impl.ITwoFView;
import com.gbq.presenter.impl.ITwoFPresenter;
import com.gbq.presenter.TwoPresenter;

/**
 * 科技新闻Fragment
 * Created by gbq on 2016-9-22.
 */
public class TwoFragment extends PageFragment implements ITwoFView {
    private TextView twoText,oneText;
    private Button twoBut,sendBut;
    private ITwoFPresenter twoPresenter;
    private ServerData serverData;

    private IMainCallBack activityCallBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activityCallBack = (IMainCallBack)getActivity();

        twoPresenter = new TwoPresenter(this);

        initView();

    }

    private void initView(){
        twoText = (TextView)getActivity().findViewById(R.id.twoText);
        oneText = (TextView)getActivity().findViewById(R.id.oneText);
        twoBut = (Button)getActivity().findViewById(R.id.twoBut);
        sendBut = (Button)getActivity().findViewById(R.id.sendBut);


        twoBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 模拟从数据库取得数据，并显示Toast
                 */
                twoPresenter.getSQLiteData();

            }
        });
    }

    @Override
    public void refreshView() {
        serverData=activityCallBack.getCommonData();
        if(serverData==null){
            activityCallBack.refreshCommonData(); //数据为空，通知Activity重新尝试获取数据
        }else{
            twoText.setText(serverData.getTwoData());
        }
    }
    /* -------------------two 自己的 MVP模式 V方法 ---------------------------*/
    @Override
    public void showToast(String str) {
        Toast toast = Toast.makeText(getActivity(), str , Toast.LENGTH_SHORT);
        toast.show();
    }
}
