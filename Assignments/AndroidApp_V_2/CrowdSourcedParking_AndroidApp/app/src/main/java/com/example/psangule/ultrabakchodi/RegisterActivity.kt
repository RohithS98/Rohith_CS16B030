package com.example.psangule.ultrabakchodi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.psangule.ultrabakchodi.MainActivity
import com.example.psangule.ultrabakchodi.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.view.*


class RegisterActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase: DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton = findViewById<View>(R.id.registerBtn) as Button


        mDatabase = FirebaseDatabase.getInstance().getReference("Names")

        registerButton.setOnClickListener(View.OnClickListener {
            view-> register()
        })
    }

    private fun register(){
        val emailTxt = findViewById<View>(R.id.email_text) as EditText
        val nameTxt = findViewById<View>(R.id.username_text) as EditText
        val passwordTxt = findViewById<View>(R.id.password_text) as EditText


        val email = emailTxt.text.toString()
        val username = nameTxt.text.toString()
        val password = passwordTxt.text.toString()


        if(username.isEmpty() && email.isEmpty() && password.isEmpty()){
            Toast.makeText(this,"Please fill the credentials :(",Toast.LENGTH_LONG).show()
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener{ task->
                if(task.isSuccessful){
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child(uid).child("Name").setValue(username)

                    Toast.makeText(this,"Successfully registered :)",Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    this.finish()
                }else{
                    Toast.makeText(this,"Error registering user",Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}
