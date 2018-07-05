package com.vega.samplecalendar;

import android.os.Parcel;
import android.os.Parcelable;

import com.applandeo.materialcalendarview.EventDay;

import java.util.Calendar;

public class MyEventDay extends EventDay implements Parcelable {

    private String mNote;
    public MyEventDay(Calendar day, int imageResource, String mNote) {
        super(day, imageResource);
        this.mNote = mNote;
    }

    public String getNote() {
        return mNote;
    }

    private MyEventDay(Parcel in) {
        super((Calendar) in.readSerializable(), in.readInt());
        mNote = in.readString();
    }

    public static final Creator<MyEventDay> CREATOR = new Creator<MyEventDay>() {
        @Override
        public MyEventDay createFromParcel(Parcel in) {
            return new MyEventDay(in);
        }
        @Override
        public MyEventDay[] newArray(int size) {
            return new MyEventDay[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(getCalendar());
        dest.writeInt(getImageResource());
        dest.writeString(mNote);
    }
}
