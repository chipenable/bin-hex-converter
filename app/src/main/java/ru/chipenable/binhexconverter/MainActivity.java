package ru.chipenable.binhexconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;

public class MainActivity extends AppCompatActivity implements IConverterView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void displayBin(String data) {

    }

    @Override
    public void displayHex(String data) {

    }

    @Override
    public void displayDec(String data) {

    }

    @Override
    public Context getAppContext() {
        return null;
    }
}
