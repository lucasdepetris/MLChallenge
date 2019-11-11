package com.depetris.lucas.mercadolibrechallenge.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {
    private String state_id;
    private String state_name;
    private String city_id;

    protected Address(Parcel in) {
        state_id = in.readString();
        state_name = in.readString();
        city_id = in.readString();
        city_name = in.readString();
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    private String city_name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(state_id);
        parcel.writeString(state_name);
        parcel.writeString(city_id);
        parcel.writeString(city_name);
    }
}
