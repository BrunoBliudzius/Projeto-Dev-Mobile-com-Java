package com.example.projetosorrisoverde;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin = findViewById(R.id.bt_login);
        btLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        Button bt_Doar = findViewById(R.id.bt_Doar);
        bt_Doar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DoarActivity.class);
            startActivity(intent);
        });
    }
}