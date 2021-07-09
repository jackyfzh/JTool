package com.example.jtool;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;



public class Tomato extends Activity {

    private int ll = 1500;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tomato);

        Button start = (Button)findViewById(R.id.start);

        timer = new Timer();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 监听回调
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void run() {
                                TextView status_show = (TextView)findViewById(R.id.status_show);

                                if (ll>0) {
                                    ll--;
                                    status_show.setText("状态：工作中");
                                }else {
                                    timer.cancel();
                                    status_show.setText("状态：休息中");
                                }
                            }
                        });
                    }
                };

                timer.schedule(timerTask,0,1000);
            }
        });

    }
}