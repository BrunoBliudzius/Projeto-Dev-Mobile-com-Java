package com.example.projetosorrisoverde;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtLogEmail, txtLogSenha;
    Button   btLogAcessar, btLogCadastre_se;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        txtLogEmail = (EditText) findViewById(R.id.txtLogEmail);
        txtLogSenha = (EditText) findViewById(R.id.txtLogSenha);
        btLogAcessar= (Button)   findViewById(R.id.btLogAcessar);
        btLogCadastre_se= (Button)   findViewById(R.id.btLogCadastre_se);
        btLogAcessar.setOnClickListener(this);
        btLogCadastre_se.setOnClickListener(this);

        btLogCadastre_se.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CadastrarActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btLogAcessar) {
            if (VerificaLogin()) {
                Intent telaMenu = new Intent(this, MainActivity.class);
                startActivity(telaMenu);
            }else{
                Toast.makeText(getApplicationContext(), "Email ou Senha inválida!", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.btLogCadastre_se){
            Intent telaCadastre_se = new Intent(this, CadastrarActivity.class);
            startActivity(telaCadastre_se);
        }
    }
    public boolean VerificaLogin() {
        Boolean retorno = false;
        String email = txtLogEmail.getText().toString();
        String senha = txtLogSenha.getText().toString();
        if (email.isEmpty() || senha.isEmpty()) {
            return retorno;
        }else{
            BancoController bd = new BancoController(getBaseContext());
            Cursor dados = bd.ConsultaLogin(email,senha) ;


            if(dados.moveToFirst()){
                retorno = true;
                btLogAcessar.setOnClickListener(v -> {
                    Intent intent = new Intent(LoginActivity.this, DoarActivity.class);
                    startActivity(intent);
                });
            }else{
                retorno = false;
            }
            return retorno;
        }
    }
}
