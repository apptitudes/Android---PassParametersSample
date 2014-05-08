package fr.apptitudes.passparameterssample.parcelableMethod;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable{

    private String brand;
    private String model;
    private String color;

    public Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public Car(Parcel in) {
        this.brand = in.readString();
        this.model = in.readString();
        this.color = in.readString();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(brand);
        parcel.writeString(model);
        parcel.writeString(color);
    }


    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>()
    {
        @Override
        public Car createFromParcel(Parcel source)
        {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size)
        {
            return new Car[size];
        }
    };
}
