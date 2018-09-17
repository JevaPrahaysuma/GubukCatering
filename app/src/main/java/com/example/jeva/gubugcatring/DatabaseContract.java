package com.example.jeva.gubugcatring;

import android.provider.BaseColumns;

/**
 * Created by jeva on 13/04/2018.
 */

public class DatabaseContract {
    public static final class DataUser implements BaseColumns{
        public static final String TABLE_Regitrasi = "datauser_table";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
    }

}
