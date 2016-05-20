package ru.chipenable.binhexconverter;

/**
 * Created by Pashgan on 20.05.2016.
 */
public interface IConverterPresenter {

    void saveData(String id, String value);
    String restoreData(String id);

    void convertHex(String data);
    void convertBin(String data);
    void convertDec(String data);
}
