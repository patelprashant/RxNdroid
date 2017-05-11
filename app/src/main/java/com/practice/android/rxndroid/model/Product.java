package com.practice.android.rxndroid.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Product implements Parcelable {
    private final String productId;
    private final String name;
    private final String description;
    private final double price;


    public Product(String productId, String name, String description, double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description + "\n";
    }

    public double getPrice() {
        return price;
    }

    public static Creator<Product> getCREATOR() {
        return CREATOR;
    }

    protected Product(Parcel in) {
        productId = in.readString();
        name = in.readString();
        description = in.readString();
        price = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( productId );
        dest.writeString( name );
        dest.writeString( description );
        dest.writeDouble( price );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product( in );
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
