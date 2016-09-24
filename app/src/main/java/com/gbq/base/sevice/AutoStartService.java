package com.gbq.base.sevice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.gbq.accountdemo.R;
import com.gbq.activity.MainActivity;

/**
 * 开机自启的服务
 * Created by gbq on 2016-9-24.
 */
public class AutoStartService extends Service {
    private static final int NOTIFICATION_ID = 1;
    NotificationManager manager;
    private final String tag = "Service";
    Context context;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Service", "Service create!");
        context = getApplicationContext();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stubm
        super.onStart(intent, startId);
        Log.d(tag, "开始服务");
        CreateInform();
    }

    // 创建通知
    public void CreateInform() {
        Notification.Builder builder = new Notification.Builder(context);
        //builder.setContentInfo("补充内容");
        builder.setContentText("进入账户中心");
        builder.setContentTitle("欢迎你");
        builder.setSmallIcon(R.mipmap.register_success);
        builder.setTicker("新消息");
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        manager.notify(NOTIFICATION_ID, notification);
    }
}
