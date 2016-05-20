package ru.chipenable.binhexconverter;

import android.content.Context;
import android.text.Spannable;

/**
 * Created by Pashgan on 20.05.2016.
 */
public interface IConverterModel {

    String hexToBin(String data);
    String hexToDec(String data);
    String binToHex(String data);
    String binToDec(String data);
    String decToHex(String data);
    String decToBin(String data);

    void saveData(Context context, String key, String data);
    String restoreData(Context context, String key);
}
