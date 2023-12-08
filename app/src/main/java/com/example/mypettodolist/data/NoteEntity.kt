package com.example.mypettodolist.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val title: String,
    val text: String,
    val date: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(uid)
        parcel.writeString(title)
        parcel.writeString(text)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NoteEntity

        if (uid != other.uid) return false
        if (title != other.title) return false
        if (text != other.text) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = uid
        result = 31 * result + title.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }

    companion object CREATOR : Parcelable.Creator<NoteEntity> {
        override fun createFromParcel(parcel: Parcel): NoteEntity {
            return NoteEntity(parcel)
        }

        override fun newArray(size: Int): Array<NoteEntity?> {
            return arrayOfNulls(size)
        }
    }
}