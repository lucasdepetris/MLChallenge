package com.depetris.lucas.mercadolibrechallenge.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Parcelable {
    private String id;
    private String title;
    private Double price;
    private String currency_id;
    private int available_quantity;
    private int sold_quantity;
    private String thumbnail;
    private String condition;
    private boolean accepts_mercadopago;
    private Seller seller;
    private Installments installments;
    private Shipping shipping;
    private Address address;

    protected Product(Parcel in) {
        id = in.readString();
        title = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        currency_id = in.readString();
        available_quantity = in.readInt();
        sold_quantity = in.readInt();
        thumbnail = in.readString();
        condition = in.readString();
        accepts_mercadopago = in.readByte() != 0;
        seller = (Seller)in.readValue(Seller.class.getClassLoader());
        installments = (Installments)in.readValue(Installments.class.getClassLoader());
        shipping = (Shipping) in.readValue(Shipping.class.getClassLoader());
        address = (Address) in.readValue(Address.class.getClassLoader());
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public int getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(int sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public void setAccepts_mercadopago(boolean accepts_mercadopago) {
        this.accepts_mercadopago = accepts_mercadopago;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        if (price == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(price);
        }
        parcel.writeString(currency_id);
        parcel.writeInt(available_quantity);
        parcel.writeInt(sold_quantity);
        parcel.writeString(thumbnail);
        parcel.writeString(condition);
        parcel.writeByte((byte) (accepts_mercadopago ? 1 : 0));
        parcel.writeValue(seller);
        parcel.writeValue(installments);
        parcel.writeValue(shipping);
        parcel.writeValue(address);
    }
}
