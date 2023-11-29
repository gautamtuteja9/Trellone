package com.gautamtuteja.trellone.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.gautamtuteja.trellone.R
import com.gautamtuteja.trellone.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private var binding : ActivitySignInBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        SetUpActionBar()

    }

    private fun SetUpActionBar(){

        setSupportActionBar(binding?.toolbarSignInActivity)

        val actionBar = supportActionBar
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        }

        binding?.toolbarSignInActivity?.setNavigationOnClickListener { onBackPressed() }
    }

}