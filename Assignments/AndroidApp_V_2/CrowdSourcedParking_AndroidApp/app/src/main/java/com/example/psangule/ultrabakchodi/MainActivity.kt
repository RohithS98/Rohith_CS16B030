package com.example.psangule.ultrabakchodi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


 class MainActivity : AppCompatActivity() {

    var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

     fun host(view: View){
         val hostIntent = Intent(this@MainActivity, HostActivity::class.java)
         startActivity(hostIntent)
     }

     fun park(view: View){
         val parkIntent = Intent(this@MainActivity, ParkActivity::class.java)
         startActivity(parkIntent)
     }
}

