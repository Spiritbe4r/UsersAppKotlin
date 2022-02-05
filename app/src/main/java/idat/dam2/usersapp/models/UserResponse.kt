package idat.dam2.useretrofit.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResponse (
    @SerializedName("data")
    val users:List<User>

): Parcelable {
    constructor():this(mutableListOf())

}