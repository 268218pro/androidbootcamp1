package com.dsc.android.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName, etEmail, etPwd, etConfirmPwd;
    private Button btnRegister;
    private String name, email, pwd, confpwd;
    public TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new TinyDB(this);
        initView();
        /*
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPwd=findViewById(R.id.etPwd);
        etConfirmPwd=findViewById(R.id.etConfirmPwd);
        btnRegister=findViewById(R.id.btnRegister);
    */
        btnRegister.setOnClickListener(this);
    }

    // we are initializing the UI Components here, through a function.
    private void initView() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPwd = findViewById(R.id.etPwd);
        etConfirmPwd = findViewById(R.id.etConfirmPwd);
        btnRegister = findViewById(R.id.btnRegister);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                getInfo();
                register();
                break;
        }
    }

    private void getInfo() {
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        pwd = etPwd.getText().toString();
        confpwd = etConfirmPwd.getText().toString();
    }

    private void register() {
        if (name.isEmpty() || email.isEmpty() || pwd.isEmpty() || confpwd.isEmpty()) {
            Toast.makeText(this, "one or more fields is empty", Toast.LENGTH_LONG).show();
        } else {
            if (pwd.equals(confpwd)) {
                Toast.makeText(this, "User Registered", Toast.LENGTH_LONG).show();
                db.putString("name",name);
                db.putString("email", email);
                db.putString("password", pwd);

                // Log.d("name :", name);
                // Log.d("email :", email);

                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Passwords did not match!!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
