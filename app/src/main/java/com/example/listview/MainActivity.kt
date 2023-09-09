package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding   //declaring view binding object for the class
    private lateinit var userArrayList : ArrayList<User>//declaring an arraylist to hold user data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creating an array that holds the integer id's of all the images
        val imageId = intArrayOf(
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j
        )

        //Creating an array that holds the names of all the users
        val name = arrayOf(
            "Gyaneshwar","Abhishek","Mitesh","Archit","Aditya",
            "Kshitij","Dharini","Payal","Aman","Satyam"
        )

        //Creating an array that holds the last messages that is to be displayed
        val lastMessage = arrayOf(
            "hey","hi","Hello","what's up","nothing",
            "what you doing","playing games","are you up?","yes","no"
        )

        //Creating an array of last message time
        val lastMsgtime = arrayOf(
            "1:00am","2:00am","3:00am","4:00am","5:00am",
            "6:00am","7:00am","8:00am","9:00am","10:00am"
        )

        //creating an array of city names
        val city = arrayOf(
            "Gandhidham","Vapi","Khargone","Ratlam","Ratlam",
            "Ahemdabad","Gandhidham","Jamnagar","Vapi","Vapi"
        )

        //creating an array of phone numbers
        val phoneNo = arrayOf(
            "9988776601","9988776602","9988776603","9988776604","9988776605",
            "9988776606","9988776607","9988776608","9988776609","9988776610"
        )

        userArrayList = ArrayList() //defining the object of arraylist

        for (i in name.indices){
            //Creating an object of User data class and initializing it with the above different arrays
            val user = User(name[i],lastMessage[i],lastMsgtime[i],phoneNo[i],city[i],imageId[i])
            userArrayList.add(user)     //adding the user object in arraylist
        }

         binding.listViewID.adapter = MyAdapter(this,userArrayList)  //defining the arrayAdapter

        binding.listViewID.isClickable = true
        binding.listViewID.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val imageId = imageId[position]
            val phoneNo = phoneNo[position]
            val city = city[position]

            //navigating from main activity to UserDetails activity with some data
            val i = Intent(this,UserDetails::class.java)
            //sending the data with intent object
            i.putExtra("name",name)
            i.putExtra("imageId",imageId)
            i.putExtra("phoneNo",phoneNo)
            i.putExtra("city",city)
            startActivity(i)
        }
    }
}