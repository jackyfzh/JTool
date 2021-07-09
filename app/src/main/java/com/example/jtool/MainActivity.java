package com.example.jtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 注册按钮
        Button dict = (Button)findViewById(R.id.dict);
        Button tomato = (Button)findViewById(R.id.tomato);

        // 定义回调
        dict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 监听回调
                Toast.makeText(getApplicationContext(), "词典", Toast.LENGTH_SHORT).show(); // 弹出
                // 新建跳转
                Intent it_1 = new Intent();
                it_1.setClass(MainActivity.this, Dict.class);
                MainActivity.this.startActivity(it_1);
            }
        });

        tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 监听回调
                Toast.makeText(getApplicationContext(), "番茄钟", Toast.LENGTH_SHORT).show(); // 弹出
                // 新建跳转
                Intent it_2 = new Intent();
                it_2.setClass(MainActivity.this, Tomato.class);
                MainActivity.this.startActivity(it_2);
            }
        });
    }
}