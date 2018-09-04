package com.example.psangule.ultrabakchodi

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import android.content.SharedPreferences



class HostActivity : Activity() {

//    private var mDatabaseReference: DatabaseReference? = null
//    private var mHostReference: DatabaseReference? = null
    private var mHostReference: DatabaseReference? = null
    lateinit var NameField: EditText
    lateinit var ContactField: EditText
    lateinit var CityField: EditText
    lateinit var AddressField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)

        //Initialize fields
        NameField = findViewById(R.id.name_field)
        ContactField = findViewById(R.id.contact_field)
        CityField = findViewById(R.id.city_field)
        AddressField = findViewById(R.id.address_field)

        //Database
//        mDatabaseReference= FirebaseDatabase.getInstance().reference
//        mHostReference = FirebaseDatabase.getInstance().getReference("Host")

    }

    fun uploadHostDetails(view: View){
//        val settings = applicationContext.getSharedPreferences("Data", 0)
//        val email = settings.getString("email", null )
        mHostReference= FirebaseDatabase.getInstance().reference
        var uuid = UUID.randomUUID().toString()
        mHostReference!!.child("Host").child(uuid).child("Name").setValue(NameField.text.toString())
        mHostReference!!.child("Host").child(uuid).child("Contact").setValue(ContactField.text.toString())
        mHostReference!!.child("Host").child(uuid).child("City").setValue(CityField.text.toString())
        mHostReference!!.child("Host").child(uuid).child("Address").setValue(AddressField.text.toString())
    }

}
