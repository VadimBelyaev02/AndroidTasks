package com.example.myapplication.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.R
import com.example.myapplication.R.drawable.elona
import com.example.myapplication.data.enums.Sex

class UserListAdapter(private val context: Context, private val userList: List<User>) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.first_screen_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        if (user.sex == Sex.MALE) {
            holder.sexView.setImageResource(R.drawable.ic_male)
        } else {
            holder.sexView.setImageResource(R.drawable.ic_female)
        }
//        val imageRequest = ImageRequest(
//            user.squareAvatarUrl,
//            { response -> holder.avatar.setImageBitmap(response) },
//            0,
//            0,
//            ImageView.ScaleType.CENTER_CROP,
//            Bitmap.Config.RGB_565,
//            { error -> error.printStackTrace() }
//        )
  //      val requestQueue = Volley.newRequestQueue(context)

//        requestQueue.add(imageRequest)


        holder.avatar.setImageResource(elona)


        holder.nameTextView.text = "${user.firstName} ${user.lastName}"
        holder.ageTextView.text = "Age: ${user.age}"
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.avatar)
        val sexView: ImageView = itemView.findViewById(R.id.sexIcon)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
    }


}