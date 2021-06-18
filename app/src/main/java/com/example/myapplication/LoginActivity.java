package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {
        if(etUsername.getText().toString().trim().equals("admin") && etPassword.getText().toString().equals(("1234"))){
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
            startActivity(new Intent(this, MainActivity.class));
        }else{
            Toast.makeText(this, "Invalid username/password.", Toast.LENGTH_SHORT).show();
            etUsername.setText("");
            etPassword.setText("");
            etUsername.requestFocus();
        }
    }
}