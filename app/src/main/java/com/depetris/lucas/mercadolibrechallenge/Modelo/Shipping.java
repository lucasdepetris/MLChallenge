package com.depetris.lucas.mercadolibrechallenge.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Shipping implements Parcelable {
    private boolean free_shipping;
    private String mode;
    ArrayList<String> tags;
    private String logistic_type;
    private boolean store_pick_up;

    protected Shipping(Parcel in) {
        free_shipping = in.readByte() != 0;
        mode = in.readString();
        tags = in.createStringArrayList();
        logistic_type = in.readString();
        store_pick_up = in.readByte() != 0;
    }

    public static final Creator<Shipping> CREATOR = new Creator<Shipping>() {
        @Override
        public Shipping createFromParcel(Parcel in) {
            return new Shipping(in);
        }

        @Override
        public Shipping[] newArray(int size) {
            return new Shipping[size];
        }
    };

    public boolean isFree_shipping() {
        return free_shipping;
    }

    public void setFree_shipping(boolean free_shipping) {
        this.free_shipping = free_shipping;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getLogistic_type() {
        return logistic_type;
    }

    public void setLogistic_type(String logistic_type) {
        this.logistic_type = logistic_type;
    }

    public boolean isStore_pick_up() {
        return store_pick_up;
    }

    public void setStore_pick_up(boolean store_pick_up) {
        this.store_pick_up = store_pick_up;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (free_shipping ? 1 : 0));
        parcel.writeString(mode);
        parcel.writeStringList(tags);
        parcel.writeString(logistic_type);
        parcel.writeByte((byte) (store_pick_up ? 1 : 0));
    }
}
