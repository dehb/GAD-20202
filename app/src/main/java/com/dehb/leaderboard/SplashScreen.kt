package com.dehb.leaderboard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.dehb.leaderboard.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout

class SplashScreen : AppCompatActivity() {

    private val Splash_time_out: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, Splash_time_out)


    }
}