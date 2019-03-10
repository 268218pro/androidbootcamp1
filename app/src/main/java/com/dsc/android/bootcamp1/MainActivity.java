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

    // Objects...
    private EditText etName, etEmail, etPwd, etConfirmPwd;
    private Button btnRegister;

    /* Declaring UI components under Public Classes and their ids , Edit Text and Button extends TextView

        @RemoteView
            public class TextView extends View implements ViewTreeObserver.OnPreDrawListener {
                                                          public final class ViewTreeObserver {
                                                                          public interface OnPreDrawListener {
        @UiThread
            public class View implements Drawable.Callback, KeyEvent.Callback,
                AccessibilityEventSource {
        public abstract class Drawable {
        public interface Callback {
        public class KeyEvent extends InputEvent implements Parcelable {
        public abstract class InputEvent implements Parcelable {
        public interface Parcelable {
    */

    // Variables...
    private String name, email, pwd, confpwd;
    //public final class String

    //Objects...
    public TinyDB db;
    //public class TinyDB

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // brings saved instances from parent
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPwd=findViewById(R.id.etPwd);
        etConfirmPwd=findViewById(R.id.etConfirmPwd);
        btnRegister=findViewById(R.id.btnRegister);
        */
        initView();
        btnRegister.setOnClickListener(this);

        // new Object created od class TinyDB to store credentials
        db = new TinyDB(this);
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

    // we are initializing the UI Components here, through a function.
    private void initView() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPwd = findViewById(R.id.etPwd);
        etConfirmPwd = findViewById(R.id.etConfirmPwd);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void getInfo() {
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        pwd = etPwd.getText().toString();
        confpwd = etConfirmPwd.getText().toString();
    }

    private void register() {
        // for pop ups
        if (name.isEmpty() || email.isEmpty() || pwd.isEmpty() || confpwd.isEmpty()) {
            Toast.makeText(this, "one or more fields is empty", Toast.LENGTH_LONG).show();
        } else {
            if (pwd.equals(confpwd)) {
                Toast.makeText(this, "User Registered", Toast.LENGTH_LONG).show();
                //to store credentials via shared preferences
                //public void putString(String key, String value) { in TinyDB
                    db.putString("name",name);
                    db.putString("email", email);
                    db.putString("password", pwd);
                    // Log.d("name :", name);
                    // Log.d("email :", email);

                    //??? used to create Menu and Submenus ???
                    // transfers to another activity
                    // only one intent
                    // use bundles to transfer data
                    Intent i = new Intent(this,LoginActivity.class);
                    // public class Intent implements Parcelable, Cloneable {
                    startActivity(i);
                    finish();
            } else {
                Toast.makeText(this, "Passwords did not match!!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
