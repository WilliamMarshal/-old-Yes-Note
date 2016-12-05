package com.vazhamarshal.yesnote.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by akaki on 05.12.16.
 */

public class Note implements Parcelable {
    private int id;
    private String title;
    private long date;
    private String content;

    public Note(int id, String title, long date, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    protected Note(Parcel in) {
        id = in.readInt();
        title = in.readString();
        date = in.readLong();
        content = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeLong(date);
        parcel.writeString(content);
    }
}
