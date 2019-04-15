package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    public int image;
    public String name;
    public String info;

    public Animal(int image, String name, String info) {
        this.image = image;
        this.name = name;
        this.info = info;
    }

    protected Animal(Parcel in) {
        image = in.readInt();
        name = in.readString();
        info = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {

        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(info);
    }
}
