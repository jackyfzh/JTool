package com.example.jtool;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class Tomato extends Activity {

    private Timer timer;
    public int ll = 1500;

    Notification notification;
    NotificationManager manager;
    private final static int NT_ID = 10;

    private void showNotification() {
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        String CHANNEL_ID = "10";
        String CHANNEL_NAME = "10";
        notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("番茄结束")
                .setContentText("辛苦了，休息一会吧！")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setVibrate(new long[]{1000, 500, 2000})
                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                .setAutoCancel(true)
                .build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(notificationChannel);
        }

        manager.notify(NT_ID, notification);
    }


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
                                    showNotification();
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