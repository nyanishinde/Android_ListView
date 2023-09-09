package com.example.listview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context : Activity, private val arrayList: ArrayList<User>) : ArrayAdapter<User>(context,
                R.layout.list_item,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item,null)

        val imageView: ImageView = view.findViewById(R.id.profile_pic)          //Creating an object and providing him an id
        val userName : TextView = view.findViewById(R.id.user_name)             //Creating an object and providing him an id
        val lastMessage : TextView = view.findViewById(R.id.last_message)       //Creating an object and providing him an id
        val lastMsgTime : TextView = view.findViewById(R.id.last_message_time)  //Creating an object and providing him an id

        imageView.setImageResource(arrayList[position].imageId)                 //setting the Images provided to the array adapter at the ImageView with help of its object
        userName.text = arrayList[position].name                                //setting the Name provided to the array adapter at the TextView with help of its object
        lastMessage.text = arrayList[position].lastMessage                      //setting the Last message provided to the array adapter at the TextView with help of its object
        lastMsgTime.text = arrayList[position].lastMsgTime                      //setting the last message time provided to the array adapter at the TextView with help of its object

        return view
    }
}