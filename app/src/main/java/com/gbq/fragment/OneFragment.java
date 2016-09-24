package com.gbq.fragment;

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
import com.gbq.fragment.impl.IOneFView;
import com.gbq.presenter.impl.IOneFPresenter;
import com.gbq.presenter.OnePresenter;

/**
 * 综合新闻Fragment
 * Created by gbq on 2016-9-22.
 */
public class OneFragment extends PageFragment implements IOneFView {

    private TextView oneText;
    private Button oneBut;
    private IOneFPresenter onePresenter;
    private ServerData serverData;

    private IMainCallBack activityCallBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activityCallBack = (IMainCallBack) getActivity();
        onePresenter = new OnePresenter(this);
        initView();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void initView() {
        oneText = (TextView) getActivity().findViewById(R.id.oneText);
        oneBut = (Button) getActivity().findViewById(R.id.oneBut);

        oneBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 模拟从数据库取得数据，并显示Toast
                 */
                onePresenter.getSQLiteData();

            }
        });
    }

    @Override
    public void refreshView() {
        serverData = activityCallBack.getCommonData();
        if (serverData == null) {
            activityCallBack.refreshCommonData(); //数据为空，通知Activity重新尝试获取数据
        } else {
            oneText.setText(serverData.getTwoData());
        }
    }


    @Override
    public void onResume() {
        /*当View重载父类方法时，首先应该调用super.onResume执行父类方法*/
        super.onResume();

    }

    /* ---------------------one 自己的 MVP模式 V方法 -----------------------------*/
    @Override
    public void showToast(String str) {
        Toast toast = Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT);
        toast.show();
    }

}
