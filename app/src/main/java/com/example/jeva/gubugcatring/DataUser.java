package com.example.jeva.gubugcatring;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by jeva on 14/04/2018.
 */

public class DataUser extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RegisterAdapter registerAdapter;
    private RegistrasiHelper registrasiHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datauser);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        registerAdapter = new RegisterAdapter(this);
        registrasiHelper = new RegistrasiHelper(this);
        getAllData();

    }
    private void getAllData() {
        registrasiHelper.open();
        ArrayList<RegistrasiModel> registrasiModels = registrasiHelper.getAllData();
        registrasiHelper.close();
        registerAdapter.addItem(registrasiModels);
        recyclerView.setAdapter(registerAdapter);
    }

}
