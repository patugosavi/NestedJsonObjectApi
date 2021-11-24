package com.example.nestedjsonobject.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportModel implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("text")
    @Expose
    private String text;

    protected SupportModel(Parcel in) {
        url = in.readString();
        text = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(text);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SupportModel> CREATOR = new Creator<SupportModel>() {
        @Override
        public SupportModel createFromParcel(Parcel in) {
            return new SupportModel(in);
        }

        @Override
        public SupportModel[] newArray(int size) {
            return new SupportModel[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
