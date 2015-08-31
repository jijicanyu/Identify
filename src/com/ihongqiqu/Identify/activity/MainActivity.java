package com.ihongqiqu.Identify.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.ihongqiqu.Identify.R;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("查询工具列表");
        }
        toolbar.setNavigationIcon(R.drawable.ic_launcher);

        slidingPaneLayout.removeViewAt(0);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_id:
                IdActivity.launch(MainActivity.this);
                break;
            case R.id.tv_phone:
                PhoneActivity.launch(MainActivity.this);
                break;
            case R.id.tv_ip:
                IpActivity.launch(MainActivity.this);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SettingActivity.launch(MainActivity.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("温馨提示");
        // builder.setCustomTitle(title);
        builder.setMessage("您确定要退出ID查询吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                overridePendingTransition(0, R.anim.sliding_out_right);
                // MobclickAgent.onKillProcess(context)
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }
}
