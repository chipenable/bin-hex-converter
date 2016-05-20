package ru.chipenable.binhexconverter;

import android.content.Context;

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


}
