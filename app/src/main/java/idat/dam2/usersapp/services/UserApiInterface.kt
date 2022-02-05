package idat.dam2.useretrofit.services

import idat.dam2.useretrofit.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface UserApiInterface {

    @GET("users?page=?")
    fun getUserList(): Call<UserResponse>
}