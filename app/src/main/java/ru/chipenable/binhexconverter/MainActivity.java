package ru.chipenable.binhexconverter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.widget.EditText;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements IConverterView {

    @BindView(R.id.dec_edit_text)EditText mDecEditText;
    @BindView(R.id.hex_edit_text)EditText mHexEditText;
    @BindView(R.id.bin_edit_text)EditText mBinEditText;

    private IConverterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new Presenter(this, new Model());
    }

    @Override
    public void displayBin(String data) {
        mBinEditText.setText(data);
    }

    @Override
    public void displayHex(String data) {
        mHexEditText.setText(data);
    }

    @Override
    public void displayDec(String data) {
        mDecEditText.setText(data);
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }
}
