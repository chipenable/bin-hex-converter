package ru.chipenable.binhexconverter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Pashgan on 20.05.2016.
 */
public class Repository implements IConverterRepository {

    private static final String PREF_NAME = "ru.chipenable.binhexconverter.repository";
    private SharedPreferences mSharedPreferences;

    public Repository(Context context){
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
    }

    @Override
    public void saveData(String key, String data) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, data);
        editor.apply();
    }

    @Override
    public String restoreData(String key) {
        return mSharedPreferences.getString(key, "");
    }
}
