package com.sdk.zql;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sdk.zqluisdk.ZQLUIManager;

public class MainActivity extends AppCompatActivity {
    EditText etTask;
    //由赚钱联盟提供的appid参数
    String saleId = "";
    //由赚钱联盟提供的key参数
    String key = "";
    //渠道方的用户ID
    String cuid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTask = findViewById(R.id.ed_task);
        //初始化数据
        ZQLUIManager.getInstance()
                .setSaleId(saleId)
                .setKey(key)
                .setcUid(cuid);
    }

    public void openZql(View view) {
        ZQLUIManager.getInstance().openTask(this);
    }

    public void openTaskDetail(View view) {
        String taskId = etTask.getText().toString().trim();
        if (TextUtils.isEmpty(taskId)) {
            Toast.makeText(this, "请输入任务ID", Toast.LENGTH_SHORT).show();
            return;
        }
        ZQLUIManager.getInstance().openTaskDetail(this, taskId);
    }

}