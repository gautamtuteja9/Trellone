package com.gautamtuteja.trellone.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.gautamtuteja.trellone.R
import com.gautamtuteja.trellone.databinding.ActivityBaseBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

open class BaseActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    private lateinit var mProgressDialog : Dialog

    private var binding:ActivityBaseBinding? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    fun showProgressDialog(text: String){
        mProgressDialog.setContentView(R.layout.dialog_progress)
        mProgressDialog.findViewById<TextView>(R.id.tv_progress_text).text = text
        mProgressDialog.show()

    }

    fun hideProgressDialog(){
        mProgressDialog.dismiss()
    }



    fun getCurrentUserId(): String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

    fun doubleBackToExit(){
        if(doubleBackToExitPressedOnce){
            super.onBackPressed()
            return
        }
        
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Back Press Again To Exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({doubleBackToExitPressedOnce = false},2000)
    }

    fun showErrorSnackBar(message:String){
        val snackbar = Snackbar.make(findViewById(android.R.id.content),
            message,Snackbar.LENGTH_LONG)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(ContextCompat.getColor(this,
            R.color.snackbar_error_color))
        snackbar.show()

    }

}
