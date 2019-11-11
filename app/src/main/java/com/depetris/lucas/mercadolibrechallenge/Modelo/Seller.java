package com.depetris.lucas.mercadolibrechallenge.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Seller implements Parcelable {
    private float id;
    private String power_seller_status;
    private boolean car_dealer;
    private boolean real_estate_agency;

    protected Seller(Parcel in) {
        id = in.readFloat();
        power_seller_status = in.readString();
        car_dealer = in.readByte() != 0;
        real_estate_agency = in.readByte() != 0;
    }

    public static final Creator<Seller> CREATOR = new Creator<Seller>() {
        @Override
        public Seller createFromParcel(Parcel in) {
            return new Seller(in);
        }

        @Override
        public Seller[] newArray(int size) {
            return new Seller[size];
        }
    };

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getPower_seller_status() {
        return power_seller_status;
    }

    public void setPower_seller_status(String power_seller_status) {
        this.power_seller_status = power_seller_status;
    }

    public boolean isCar_dealer() {
        return car_dealer;
    }

    public void setCar_dealer(boolean car_dealer) {
        this.car_dealer = car_dealer;
    }

    public boolean isReal_estate_agency() {
        return real_estate_agency;
    }

    public void setReal_estate_agency(boolean real_estate_agency) {
        this.real_estate_agency = real_estate_agency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(id);
        parcel.writeString(power_seller_status);
        parcel.writeByte((byte) (car_dealer ? 1 : 0));
        parcel.writeByte((byte) (real_estate_agency ? 1 : 0));
    }
}
