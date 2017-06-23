package com.example.juliette.myapplication;

// tools:context="com.example.juliette.myapplication.UserAreaActivity$PlaceholderFragment"

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etSenha = (EditText) findViewById(R.id.etSenha);
        final Button bEntrar = (Button) findViewById(R.id.bEntrar);
        final TextView tvNovoAqui = (TextView) findViewById(R.id.tvNovoAqui);
        //final ImageView ivLogo = (ImageView) findViewById(R.id.ivLogo);
        //ivLogo.setImageResource(R.drawable.ivLogo);

        tvNovoAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NovoAquiIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(NovoAquiIntent);
            }
        });

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bEntrarIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                LoginActivity.this.startActivity(bEntrarIntent);
            }
        });


    }
}
