package com.example.jeva.gubugcatring;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static android.provider.MediaStore.Audio.Playlists.Members._ID;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.COLUMN_PASSWORD;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.COLUMN_USERNAME;
import static com.example.jeva.gubugcatring.DatabaseContract.DataUser.TABLE_Regitrasi;

/**
 * Created by jeva on 14/04/2018.
 */

public class LoginHelper {
    private Context context;
    private DatabaseHelper dataBaseHelper;
    private SQLiteDatabase database;
    public LoginHelper(Context context){
        this.context = context;
    }
    public LoginHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dataBaseHelper.close();
    }
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                _ID
        };
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USERNAME + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_Regitrasi, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}


