package ru.chipenable.binhexconverter;

/**
 * Created by Pashgan on 20.05.2016.
 */
public interface IConverterRepository {

    void saveData(String key, String data);
    String restoreData(String key);
}
