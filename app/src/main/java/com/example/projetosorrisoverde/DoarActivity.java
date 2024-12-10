package com.example.projetosorrisoverde;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;

import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class DoarActivity extends AppCompatActivity implements OnClickListener {

    Button bt_doar;
    EditText txtdoacao, txtquant;


    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doar);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.FacaDoacao), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bt_quemsomos = findViewById(R.id.bt_quemsomos);
        bt_quemsomos.setOnClickListener(v -> {
            Intent intent = new Intent(DoarActivity.this, MainActivity.class);
            startActivity(intent);
        });

        txtdoacao = (EditText) findViewById(R.id.txtdoacao);
        txtquant = (EditText) findViewById(R.id.txtquant);

        bt_doar = (Button) findViewById(R.id.bt_doar);
        bt_doar.setOnClickListener(this);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.bt_doar) {
            salvar();
        }
    }

    public void salvar() {
        String msg = "";
        String txtNome = txtdoacao.getText().toString();
        String txtEmail = txtquant.getText().toString();

        if (txtNome.isEmpty() || txtEmail.isEmpty())
        {
            msg = "Atenção - Os campos Nome e E-mail devem ser preenchidos!!!";
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        }else {
            BancoController bd = new BancoController(getBaseContext());
            String resultado;

            resultado = bd.insereDados(txtNome, txtEmail);

            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            limpar();
        }
    }
    public void limpar(){
        txtdoacao.setText("") ;
        txtquant.setText("") ;
    }
}
