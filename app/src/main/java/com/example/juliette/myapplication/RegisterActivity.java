package com.example.juliette.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etNome = (EditText) findViewById(R.id.etNome);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etSenha = (EditText) findViewById(R.id.etSenha);
        final EditText etConfirmarSenha = (EditText) findViewById(R.id.etConfirmarSenha);
        final Button bCriar = (Button) findViewById(R.id.bCriar);

    }
}
