package com.example.jeva.gubugcatring;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jeva on 14/04/2018.
 */

public class Registrasi extends AppCompatActivity{

    private Button btn_signup;
    private EditText edt_email, edt_username, edt_password;
    private RegisterAdapter registerAdapter;
    private RegistrasiHelper registrasiHelper;

    private DatabaseHelper dbHelper;
    private SQLiteDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.btn_signup = (Button) findViewById(R.id.btn_signup);
        this.edt_email = (EditText) findViewById(R.id.et_email);
        this.edt_username = (EditText) findViewById(R.id.et_us);
        this.edt_password = (EditText) findViewById(R.id.et_password);

        registerAdapter = new RegisterAdapter(this);
        registrasiHelper = new RegistrasiHelper(this);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                Intent i = new Intent(Registrasi.this, DataUser.class);
                startActivity(i);
            }
        });





    }
    private void insertData() {
        registrasiHelper.open();
        RegistrasiModel registrasi = new RegistrasiModel(edt_email.getText().toString(), edt_username.getText().toString(), edt_password.getText().toString());
        registrasiHelper.insert(registrasi);
        registrasiHelper.close();
    }
}
