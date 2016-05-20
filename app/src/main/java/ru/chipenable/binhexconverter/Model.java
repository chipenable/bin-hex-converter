package ru.chipenable.binhexconverter;

import android.content.Context;
import android.util.Log;

/**
 * Created by Pashgan on 20.05.2016.
 */
public class Model implements IConverterModel {

    private final String TAG = this.getClass().getName();

    private static final int DEC_RADIX = 10;
    private static final int HEX_RADIX = 16;
    private static final int BIN_RADIX = 2;

    private String converter(String data, int inRadix, int outRadix) {
        String result = "";

        if (data != null && !data.equals("")) {
            try {
                long dec = Long.valueOf(data, inRadix);
                result = Long.toString(dec, outRadix);
            }
            catch(Exception e){
               Log.d(TAG, e.getMessage());
            }
        }

        return result.toUpperCase();
    }

    @Override
    public String hexToBin(String data) {
        return converter(data, HEX_RADIX, BIN_RADIX);
    }

    @Override
    public String hexToDec(String data) {
        return converter(data, HEX_RADIX, DEC_RADIX);
    }

    @Override
    public String binToHex(String data) {
        return converter(data, BIN_RADIX, HEX_RADIX);
    }

    @Override
    public String binToDec(String data) {
        return converter(data, BIN_RADIX, DEC_RADIX);
    }

    @Override
    public String decToHex(String data) {
        return converter(data, DEC_RADIX, HEX_RADIX);
    }

    @Override
    public String decToBin(String data) {
        return converter(data, DEC_RADIX, BIN_RADIX);
    }

    @Override
    public void saveData(Context context, String key, String data) {

    }

    @Override
    public String restoreData(Context context, String key) {
        return null;
    }
}
