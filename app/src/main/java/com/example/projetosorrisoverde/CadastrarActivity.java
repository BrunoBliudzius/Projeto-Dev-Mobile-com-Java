package com.example.projetosorrisoverde;

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
public class CadastrarActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtCadNome, txtCadEmail, txtCadCPF, txtCadSenha, txtCadConfSenha;
    Button btCadCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cadastre_se), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtCadNome = (EditText) findViewById(R.id.txtCadNome);
        txtCadEmail = (EditText) findViewById(R.id.txtCadEmail);
        txtCadCPF = (EditText) findViewById(R.id.txtCadCPF);
        txtCadSenha = (EditText) findViewById(R.id.txtCadSenha);
        txtCadConfSenha = (EditText) findViewById(R.id.txtCadConfSenha);
        btCadCadastrar = (Button) findViewById(R.id.btCadCadastrar);
        btCadCadastrar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        //capturando os dados digitados e armazenando em variáveis
        String _nome  = txtCadNome.getText().toString();
        String _email = txtCadEmail.getText().toString();
        String _cpf   = txtCadCPF.getText().toString();
        String _senha = txtCadSenha.getText().toString();
        String _confsenha = txtCadConfSenha.getText().toString();
        boolean erro = false;
        //verificações
        if (_nome.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha o campo Nome!", Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (_email.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha o campo E-mail!", Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (_cpf.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha o campo CPF!", Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (_senha.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha o campo Senha!", Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (_confsenha.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha o campo Confirma Senha!", Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (!_senha.equals(_confsenha)){
            Toast.makeText(getApplicationContext(), "As senhas não são iguais!", Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (!erro) {
            // houve o preenchimento dos campos e senha e confsenha são iguais
            // gravar os dados
            BancoController bd = new BancoController(getBaseContext());
            String resultado;
            resultado = bd.insereDadosUsuario(_nome, _email, _cpf, _senha);
            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        }
    }
}
