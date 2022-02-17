package com.digimaster.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digimaster.finalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var id = intent.getStringExtra("id")
        var name = intent.getStringExtra("name")
        var email = intent.getStringExtra("email")
        binding.tvUserEmail.text = "Email: $email"
        binding.tvUserId.text = "userId: $id"
        binding.tvUserName.text = "userName: $name"

    }
}