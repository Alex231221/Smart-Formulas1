package com.example.SmartFormulas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void main_btn(View view) {
        switch (view.getId()){
            case R.id.btn_play:
                startActivity(new Intent(MainActivity.this , com.example.SmartFormulas.playActivity.class));
                break;
            case R.id.btn_setting:
                startActivity(new Intent(MainActivity.this , com.example.SmartFormulas.settingActivity.class));

                break;
            case R.id.btn_exit:
                this.finishAffinity();
                break;
        }
    }
}