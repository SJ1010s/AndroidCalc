package com.home.androidcalc;

import android.os.Parcel;
import android.os.Parcelable;

public class Save implements Parcelable {
    private int typeOfImage;

    protected Save(Parcel in) {
        typeOfImage = in.readInt();
    }

    public static final Creator<Save> CREATOR = new Creator<Save>() {
        @Override
        public Save createFromParcel(Parcel in) {
            return new Save(in);
        }

        @Override
        public Save[] newArray(int size) {
            return new Save[size];
        }
    };

    public Save() {
        typeOfImage = 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(typeOfImage);
    }

    public int getTypeOfImage(){
        return typeOfImage;
    }
    public void setTypeOfImage(int type){
        typeOfImage = type;
    }
}
