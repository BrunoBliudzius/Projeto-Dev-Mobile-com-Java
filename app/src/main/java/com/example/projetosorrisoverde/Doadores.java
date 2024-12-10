package com.example.projetosorrisoverde;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Doadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doadores);

        Button btmain = findViewById(R.id.bt_quemsomos);
        btmain.setOnClickListener(v -> {
            Intent intent = new Intent(Doadores.this, MainActivity.class);
            startActivity(intent);
        });

        Button btLogin = findViewById(R.id.bt_login);
        btLogin.setOnClickListener(v -> {
            Intent intent = new Intent(Doadores.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}