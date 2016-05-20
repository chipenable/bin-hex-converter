package ru.chipenable.binhexconverter;

import android.content.SharedPreferences;

/**
 * Created by Pashgan on 20.05.2016.
 */
public class Repository implements IConverterRepository {

    private SharedPreferences mSharedPreferences;

    public Repository(SharedPreferences pref){
        mSharedPreferences = pref;
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
