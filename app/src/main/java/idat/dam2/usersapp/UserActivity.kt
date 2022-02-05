package idat.dam2.usersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import idat.dam2.useretrofit.models.User
import idat.dam2.useretrofit.models.UserResponse
import idat.dam2.useretrofit.services.UserApiInterface
import idat.dam2.useretrofit.services.UserApiService
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        rv_users_list.layoutManager= LinearLayoutManager(this)
        rv_users_list.setHasFixedSize(true)
        getUserData { users:List<User> ->
            rv_users_list.adapter=UserAdapter(users)
        }
    }

    private fun getUserData(callback: (List<User>)-> Unit){
        val apiService= UserApiService.getInstance().create(UserApiInterface::class.java)
        apiService.getUserList().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                return callback(response.body()!!.users)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {

            }
        })

    }


}