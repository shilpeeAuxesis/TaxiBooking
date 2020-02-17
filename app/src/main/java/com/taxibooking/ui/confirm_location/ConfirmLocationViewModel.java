package com.taxibooking.ui.confirm_location;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class ConfirmLocationViewModel extends ViewModel {
    private static final String TAG = "ConfirmLocationViewMode";
    private MutableLiveData<String> mText;

    public ConfirmLocationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }


}