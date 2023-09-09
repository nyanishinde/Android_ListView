package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview.databinding.ActivityMainBinding
import com.example.listview.databinding.ActivityUserDetailsBinding

class UserDetails : AppCompatActivity() {
    private lateinit var binding: ActivityUserDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setting the data that came with intent object to their respected places
        binding.userProfileImg.setImageResource(intent.getIntExtra("imageId",R.drawable.a))
        binding.userProfileName.setText(intent.getStringExtra("name"))
        binding.userProfileNumber.setText(intent.getStringExtra("phoneNo"))
        binding.userProfileCity.setText(intent.getStringExtra("city"))
    }
}