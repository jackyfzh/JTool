package com.example.jtool;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dict extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dict);

        Button s_box = (Button)findViewById(R.id.search_box);

        s_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 监听回调
                EditText s = (EditText)findViewById(R.id.search);
                TextView w = (TextView)findViewById(R.id.word);
                String cn = s.getText().toString();
                w.setText(cn);
            }
        });
    }
}