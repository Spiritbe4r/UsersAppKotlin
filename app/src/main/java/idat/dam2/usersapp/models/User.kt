package idat.dam2.useretrofit.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (

    @SerializedName( "id")
    val id : String?,

    @SerializedName("email")
    val email : String?,
    @SerializedName("first_name")
    val first_name : String?,
    @SerializedName("last_name")
    val last_name : String?,
    @SerializedName("avatar")
    val avatar : String?

):Parcelable{
    constructor():this("","","","","")
}