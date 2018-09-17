package com.example.jeva.gubugcatring;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.COLUMN_EMAIL;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.COLUMN_PASSWORD;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.COLUMN_USERNAME;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.TABLE_Regitrasi;

/**
 * Created by jeva on 13/04/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "gubug.db";
    private static final int DATABASE_VERSION = 3;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    public static String CREATE_TABLE_REGISTRASI = "create table " + TABLE_Regitrasi +
            " (" + _ID + " integer primary key autoincrement, " +
             COLUMN_EMAIL+ " text not null, " +
            COLUMN_USERNAME + " text not null, " +
            COLUMN_PASSWORD + " text not null);";

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+
                TABLE_Regitrasi);
        onCreate(sqLiteDatabase);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_REGISTRASI);


    }
}
