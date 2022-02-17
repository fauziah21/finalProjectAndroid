package com.digimaster.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digimaster.finalproject.databinding.ActivityLoginBinding
import com.digimaster.finalproject.utils.PrefsKeys
import com.pixplicity.easyprefs.library.Prefs

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener{
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            Prefs.putString(PrefsKeys.USERNAME, username)
            Prefs.putString(PrefsKeys.PASSWORD, password)
            Prefs.putBoolean(PrefsKeys.IS_LOGIN, true)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}