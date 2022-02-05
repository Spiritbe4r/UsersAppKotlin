package idat.dam2.usersapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import idat.dam2.useretrofit.models.User
import kotlinx.android.synthetic.main.user_item.view.*


class UserAdapter (
    private val users:List<User>
    ):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
        class UserViewHolder(view: View):RecyclerView.ViewHolder(view){
            private val IMAGE_BASE = "https://reqres.in/img/faces/"

            fun bindUser(user:User){
                itemView.user_name.text=user.first_name
                itemView.user_email.text=user.email
                Glide.with(itemView).load(IMAGE_BASE+user.id+"-image.jpg").into(itemView.user_poster)


            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(users.get(position))
    }

    override fun getItemCount(): Int=users.size



    }

