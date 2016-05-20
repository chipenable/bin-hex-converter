package ru.chipenable.binhexconverter;

import android.support.v4.os.IResultReceiver;

import java.lang.ref.WeakReference;

/**
 * Created by Pashgan on 20.05.2016.
 */
public class Presenter implements IConverterPresenter {

    private WeakReference<IConverterView> mView;
    private IConverterModel mModel;
    private IConverterRepository mRepository;

    public Presenter(IConverterView view, IConverterModel model, IConverterRepository repo){
        mView = new WeakReference<>(view);
        mModel = model;
        mRepository = repo;
    }

    @Override
    public void saveData(String id, String value) {
        mRepository.saveData(id, value);
    }

    @Override
    public String restoreData(String id) {
        return mRepository.restoreData(id);
    }

    @Override
    public void convertHex(String data) {
        String dec = mModel.hexToDec(data);
        String bin = mModel.hexToBin(data);
        displayData(dec, null, bin);
    }

    @Override
    public void convertBin(String data) {
        String dec = mModel.binToDec(data);
        String hex = mModel.binToHex(data);
        displayData(dec, hex, null);
    }

    @Override
    public void convertDec(String data) {
        String hex = mModel.decToHex(data);
        String bin = mModel.decToBin(data);
        displayData(null, hex, bin);
    }

    private void displayData(String dec, String hex, String bin){
        IConverterView view = mView.get();
        if (view == null){
            return;
        }

        if (dec != null){
            view.displayDec(dec);
        }

        if (hex != null){
            view.displayHex(hex);
        }

        if (bin != null){
            view.displayBin(bin);
        }
    }
}
