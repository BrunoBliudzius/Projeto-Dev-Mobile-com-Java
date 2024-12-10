package com.example.projetosorrisoverde;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;


    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }


    public String insereDados(String txtNome, String txtEmail) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", txtNome);
        valores.put("email", txtEmail);

        resultado = db.insert("contatos", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public String insereDadosUsuario(String _nome, String _email, String _cpf, String _senha){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();


        valores = new ContentValues();
        valores.put("nome", _nome);
        valores.put("email", _email);
        valores.put("cpf", _cpf);
        valores.put("senha", _senha);


        resultado = db.insert("Usuarios", null, valores);
        db.close();


        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor ConsultaLogin(String _email, String _senha) {
        Cursor cursor;
        String[] campos = {"idUser", "nome", "email", "senha", "cpf" };
        String where = "email = '" + _email + "' and senha = '" + _senha + "'";
        db= banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
