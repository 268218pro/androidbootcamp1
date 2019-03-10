package com.dsc.android.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText giveLoginId, givePwd;
    private Button loginbtn;
    private String id, pwd;
    public TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginView();
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
            getInfo();
            login();
            break;
        }
    }

    public void loginView(){
        giveLoginId= findViewById(R.id.giveLoginId);
        givePwd = findViewById(R.id.givePwd);
        loginbtn = findViewById(R.id.btnRegister);
    }

    private void getInfo() {
        id = giveLoginId.getText().toString().trim();
        pwd = givePwd.getText().toString();
    }

    private void login(){
        if (id.isEmpty() || pwd.isEmpty()){
            Toast.makeText(this, "one or more fields is empty", Toast.LENGTH_LONG).show();
        } else {
            if (id.equals(db.getString("name"))) {
            if (pwd.equals(db.getString("password"))) {
                Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show();

                Intent i = new Intent(this,HomeActivity.class);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Credentials did not match!!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
