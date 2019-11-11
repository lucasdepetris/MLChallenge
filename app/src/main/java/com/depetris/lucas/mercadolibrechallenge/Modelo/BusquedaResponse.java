package com.depetris.lucas.mercadolibrechallenge.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class BusquedaResponse implements Parcelable {
    private String query;
    private List<Product> results;

    protected BusquedaResponse(Parcel in) {
        query = in.readString();
        results = in.createTypedArrayList(Product.CREATOR);
    }

    public static final Creator<BusquedaResponse> CREATOR = new Creator<BusquedaResponse>() {
        @Override
        public BusquedaResponse createFromParcel(Parcel in) {
            return new BusquedaResponse(in);
        }

        @Override
        public BusquedaResponse[] newArray(int size) {
            return new BusquedaResponse[size];
        }
    };

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(query);
        dest.writeTypedList(results);
    }
}
