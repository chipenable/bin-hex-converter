package ru.chipenable.binhexconverter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IConverterView,
        View.OnFocusChangeListener {

    @BindView(R.id.dec_edit_text)EditText mDecEditText;
    @BindView(R.id.hex_edit_text)EditText mHexEditText;
    @BindView(R.id.bin_edit_text)EditText mBinEditText;

    private IConverterPresenter mPresenter;

    private TextWatcher mDecTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            mPresenter.convertDec(s.toString());
        }
    };

    private TextWatcher mHexTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            mPresenter.convertHex(s.toString());
        }
    };

    private TextWatcher mBinTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            mPresenter.convertBin(s.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        IConverterRepository repository = new Repository(this.getPreferences(Activity.MODE_PRIVATE));
        IConverterModel model = new Model(repository);
        mPresenter = new Presenter(this, model);

        mDecEditText.setOnFocusChangeListener(this);
        mHexEditText.setOnFocusChangeListener(this);
        mBinEditText.setOnFocusChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData(mDecEditText);
        restoreData(mHexEditText);
        restoreData(mBinEditText);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData(mDecEditText);
        saveData(mHexEditText);
        saveData(mBinEditText);
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

    private void saveData(EditText view){
        String id = Integer.toString(view.getId());
        String data = view.getText().toString();
        mPresenter.saveData(id, data);
    }

    private void restoreData(EditText view){
        String id = Integer.toString(view.getId());
        String data = mPresenter.restoreData(id);
        view.setText(data);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        mDecEditText.removeTextChangedListener(mDecTextWatcher);
        mHexEditText.removeTextChangedListener(mHexTextWatcher);
        mBinEditText.removeTextChangedListener(mBinTextWatcher);

        setTextWatcher(mDecEditText, mDecTextWatcher);
        setTextWatcher(mHexEditText, mHexTextWatcher);
        setTextWatcher(mBinEditText, mBinTextWatcher);
    }



    /********************** util functions ***************************/

    private void setTextWatcher(EditText editText, TextWatcher textWatcher){
        if (editText.isFocused()){
            editText.addTextChangedListener(textWatcher);
        }
    }
}
