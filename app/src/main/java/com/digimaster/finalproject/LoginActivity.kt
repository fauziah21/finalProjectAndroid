package com.digimaster.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.digimaster.finalproject.databinding.ActivityLoginBinding
import com.digimaster.finalproject.model.requestLogin.RequestLogin
import com.digimaster.finalproject.utils.PrefsKeys
import com.digimaster.finalproject.viewmodel.LoginViewModel
import com.pixplicity.easyprefs.library.Prefs

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private val viewModel:LoginViewModel by lazy{
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener{
            viewModel.postLogin(RequestLogin( binding.etUsername.text.toString(), binding.etPassword.text.toString()))
//            val username = binding.etUsername.text.toString()
//            val password = binding.etPassword.text.toString()
//            Prefs.putString(PrefsKeys.USERNAME, username)
//            Prefs.putString(PrefsKeys.PASSWORD, password)
//            Prefs.putBoolean(PrefsKeys.IS_LOGIN, true)
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
        setObserver()
    }

    private fun setObserver() {
        viewModel.listResponse().observe(this, {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("id", it.data.userId.toString())
            intent.putExtra("name", it.data.userName.toString())
            intent.putExtra("email", it.data.userEmail.toString())
            startActivity(intent)
        })
        viewModel.getIsError().observe(this, {
            if (it){
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        })
    }
}