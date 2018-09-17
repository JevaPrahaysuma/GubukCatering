package com.example.jeva.gubugcatring;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.COLUMN_EMAIL;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.COLUMN_PASSWORD;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.COLUMN_USERNAME;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.TABLE_Regitrasi;


/**
 * Created by jeva on 14/04/2018.
 */

public class RegistrasiHelper {
    private Context context;
    private DatabaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public RegistrasiHelper(Context context) {
        this.context = context;
    }

    public RegistrasiHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dataBaseHelper.close();
    }

    public long insert(RegistrasiModel registrasiModel) {
        ContentValues initialValues = new ContentValues();
        database.beginTransaction();
        try {
            initialValues.put(COLUMN_EMAIL , registrasiModel.getEmail());
            initialValues.put(COLUMN_USERNAME, registrasiModel.getUsername());
            initialValues.put(COLUMN_PASSWORD, registrasiModel.getPassword());
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
        return database.insert(TABLE_Regitrasi, null, initialValues);
    }

    public ArrayList<RegistrasiModel> getAllData() {
        Cursor cursor = database.query(TABLE_Regitrasi, null, null, null, null, null, _ID + " DESC", null);
        cursor.moveToFirst();
        ArrayList<RegistrasiModel> arrayList = new ArrayList<>();
        RegistrasiModel registrasiModel;
        if (cursor.getCount() > 0) {
            do {
                registrasiModel = new RegistrasiModel();
                registrasiModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                registrasiModel.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)));
                registrasiModel.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME)));
                registrasiModel.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)));
                arrayList.add(registrasiModel);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }
    public int update(RegistrasiModel registrasiModel) {
        ContentValues args = new ContentValues();
        database.beginTransaction();
        try {
            args.put(COLUMN_EMAIL, registrasiModel.getEmail());
            args.put(COLUMN_USERNAME, registrasiModel.getUsername());
            args.put(COLUMN_PASSWORD, registrasiModel.getPassword());
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }

        return database.update(TABLE_Regitrasi, args, _ID + "= '" + registrasiModel.getId() + "'", null);
    }
    public int delete(int id) {
        return database.delete(TABLE_Regitrasi, _ID + " = '" + id + "'", null);
    }
    public ArrayList<RegistrasiModel> getSomeData2(String username) {
        Cursor cursor = database.query(TABLE_Regitrasi, null, DatabaseContract.DataUser.COLUMN_USERNAME+ " LIKE '%"+ username +"%'", null, null, null, _ID + " DESC", null);
        cursor.moveToFirst();
        ArrayList<RegistrasiModel> arrayList = new ArrayList<>();
        RegistrasiModel registrasiModel;
        if (cursor.getCount() > 0) {
            do {
                registrasiModel = new RegistrasiModel();
                registrasiModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                registrasiModel.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)));
                registrasiModel.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME)));
                registrasiModel.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)));
                arrayList.add(registrasiModel);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

}
