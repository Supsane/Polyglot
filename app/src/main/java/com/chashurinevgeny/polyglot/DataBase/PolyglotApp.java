package com.chashurinevgeny.polyglot.DataBase;

import android.app.Application;

/**
 * Created by Chashurin Evgeny on 01.11.2017.
 */

public class PolyglotApp extends Application {

    private DataBaseHelper dataBaseHelper = null;

    @Override
    public void onCreate() {
        super.onCreate();
        dataBaseHelper = new DataBaseHelper(getApplicationContext());
    }

    public DataBaseHelper getDataBaseHelper() {
        return dataBaseHelper;
    }
}
