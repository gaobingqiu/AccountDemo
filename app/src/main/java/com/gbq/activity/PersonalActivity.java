package com.gbq.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gbq.accountdemo.R;
import com.gbq.base.tools.JsonUtil;
import com.gbq.dto.User;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.net.HttpUtil;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户个人中心
 * Created by gbq on 2016-9-24.
 */
public class PersonalActivity extends Activity {
    TextView userNameView;
    String tag = "personal";
    ListView linkList;
    private User user;
    private ImageView mPersonalImg;
    private int[] images = {R.mipmap.mus_cai_icon03, R.mipmap.mus_cai_icon04, R.mipmap.mus_cai_icon05,
            R.mipmap.mus_cai_icon06, R.mipmap.mus_cai_icon07};
    private String[] mListTitle = {"实名认证", "手机绑定", "邮箱绑定", "登录密码管理", "常见问题"};
    ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_personal);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (null != bundle) {
            String jsonUser = bundle.getString("user");
            user = JsonUtil.createJsonBean(jsonUser, User.class);
            userNameView = (TextView) findViewById(R.id.personalName);
            userNameView.setText(user.getUserName());
        }
        mPersonalImg = (ImageView) findViewById(R.id.personal_img);
        setList();
        getImg(user.getAndroidImage());
    }

    public void getImg(String url) {
        // 加载网络图片begin
        // 创建客户端对象
        url = HttpUtil.SERVER_IP + url;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    BitmapFactory factory = new BitmapFactory();
                    Bitmap bitmap = factory.decodeByteArray(responseBody, 0, responseBody.length);
                    mPersonalImg.setImageBitmap(bitmap);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                error.printStackTrace();
            }
        });
        // 加载网络图片end
    }

    public void toOut(View view) {
        Log.d(tag, "userOut");
        Intent intent = new Intent();
        intent.setClass(PersonalActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void toNews(View view) {
        Intent intent = new Intent();
        //intent.setClass(PersonalActivity.this, NewsMainActivity.class);
        startActivity(intent);
    }

    public void changeImg(View view) {
        Intent intent = new Intent();
        intent.setClass(PersonalActivity.this, PhotoActivity.class);
        startActivity(intent);
    }

    public void setList() {
        linkList = (ListView) findViewById(R.id.lv_link);
        int lengh = mListTitle.length;
        for (int i = 0; i < lengh; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", images[i]);
            item.put("title", mListTitle[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, mData, R.layout.list_person_title_item, new String[]{"image", "title"},
                new int[]{R.id.image, R.id.link_name});
        linkList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        linkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(PersonalActivity.this, "您选择了标题：" + mListTitle[arg2], Toast.LENGTH_LONG).show();
            }
        });
    }
}
