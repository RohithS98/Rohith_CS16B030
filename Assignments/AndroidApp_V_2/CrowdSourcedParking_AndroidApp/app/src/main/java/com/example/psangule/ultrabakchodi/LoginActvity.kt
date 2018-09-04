package com.example.psangule.ultrabakchodi

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.psangule.ultrabakchodi.RegisterActivity
import com.example.psangule.ultrabakchodi.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import java.util.logging.Logger.global
import android.R.id.edit
import android.content.SharedPreferences



class LoginActvity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    val MainActivity: Activity = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_actvity)

        val loginBtn = findViewById<View>(R.id.login_button) as Button
        val registerTxt = findViewById<View>(R.id.registerTxt) as TextView

        loginBtn.setOnClickListener(View.OnClickListener{
            view-> login()
        })

        registerTxt.setOnClickListener(View.OnClickListener{
            view-> register()

        })

    }
    private fun login(){
        val emailTxt = findViewById<View>(R.id.email) as EditText
        val passwordTxt = findViewById<View>(R.id.password) as EditText

        val email = emailTxt.text.toString()
        val password  = passwordTxt.text.toString()

        if(email.isEmpty() && password.isEmpty()){
            Toast.makeText(this,"Please fill the credentials :(",Toast.LENGTH_LONG).show()
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful){
                    startActivity(Intent(this,MainActivity::class.java))
                    this.finish()
                    Toast.makeText(this,"Successfully logged in :)",Toast.LENGTH_LONG).show()

                    //Store email to local
                    val data = applicationContext.getSharedPreferences("Data", 0)
                    val editor = data.edit()
                    editor.putString("email", email)

                }else{
                    Toast.makeText(this,"Error,Login Failed",Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun register(){
        startActivity(Intent(this, RegisterActivity::class.java))

    }
}
