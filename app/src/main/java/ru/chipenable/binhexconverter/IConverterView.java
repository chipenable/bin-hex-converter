package ru.chipenable.binhexconverter;

import android.content.Context;

/**
 * Created by Pashgan on 20.05.2016.
 */
public interface IConverterView {

    void displayBin(String data);
    void displayHex(String data);
    void displayDec(String data);
    Context getAppContext();
}
