package com.taxibooking.ui.choose_destination.choose_model;

public class VehicleModel {
    String vehicleName;

    public VehicleModel() {
    }

    public VehicleModel(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleName() {
        return vehicleName;
    }
}
