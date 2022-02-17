package com.digimaster.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.digimaster.finalproject.databinding.ActivitySplashScreenBinding
import com.digimaster.finalproject.utils.PrefsKeys
import com.pixplicity.easyprefs.library.Prefs

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val isLogin = Prefs.getBoolean(PrefsKeys.IS_LOGIN, false)
            if (isLogin){
                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
            } else{
                val intent = Intent(this, LoginActivity::class.java)
                this.startActivity(intent)
            }

        }, 3000)
    }
}