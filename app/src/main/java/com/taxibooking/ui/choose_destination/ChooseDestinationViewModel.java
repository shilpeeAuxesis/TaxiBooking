package com.taxibooking.ui.choose_destination;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChooseDestinationViewModel extends ViewModel {
    private static final String TAG = "ChooseDestinationViewMo";
    private MutableLiveData<String> mText;

    public ChooseDestinationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText(){
        return mText;
    }
}