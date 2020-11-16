package com.example.quicknote.utils

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import java.io.Serializable

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
//测试!!
class aa() : Parcelable {
    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<aa> {
        override fun createFromParcel(parcel: Parcel): aa {
            return aa(parcel)
        }

        override fun newArray(size: Int): Array<aa?> {
            return arrayOfNulls(size)
        }
    }
}

class g() : Serializable