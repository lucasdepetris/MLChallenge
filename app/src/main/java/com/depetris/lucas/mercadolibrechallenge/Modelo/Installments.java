package com.depetris.lucas.mercadolibrechallenge.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Installments implements Parcelable {
    private float quantity;
    private float amount;
    private float rate;
    private String currency_id;

    protected Installments(Parcel in) {
        quantity = in.readFloat();
        amount = in.readFloat();
        rate = in.readFloat();
        currency_id = in.readString();
    }

    public static final Creator<Installments> CREATOR = new Creator<Installments>() {
        @Override
        public Installments createFromParcel(Parcel in) {
            return new Installments(in);
        }

        @Override
        public Installments[] newArray(int size) {
            return new Installments[size];
        }
    };

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(quantity);
        parcel.writeFloat(amount);
        parcel.writeFloat(rate);
        parcel.writeString(currency_id);
    }
}
