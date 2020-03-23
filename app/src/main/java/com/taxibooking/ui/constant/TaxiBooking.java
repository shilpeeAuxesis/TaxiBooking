package com.taxibooking.ui.constant;

import android.app.Application;


public class TaxiBooking extends Application {
private static TaxiBooking mInstance;

    public TaxiBooking() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public static TaxiBooking getInstance(){
        if (mInstance == null){ // if there is no instance available... create new one
            mInstance = new TaxiBooking();
        }
        return mInstance;
    }
}
