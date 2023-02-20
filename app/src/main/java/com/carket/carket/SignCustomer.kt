package com.carket.carket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignCustomer : BaseActivity() {
    // The initialize of databaseReference important for inserting data
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_customer)
        val signBtn = findViewById<Button>(R.id.SignBtn)


        // The Button of signing up a new user and inserting it to the firebase
        signBtn.setOnClickListener{
            val name = findViewById<EditText>(R.id.nameCustSign).text.toString()
            val usernm = findViewById<EditText>(R.id.usrnmCustSign).text.toString().trim()
            val mail = findViewById<EditText>(R.id.mailCustSign).text.toString()
            val pass = findViewById<EditText>(R.id.passCustSign).text.toString()
            val phone = findViewById<EditText>(R.id.phoneCustSign).text.toString()
            val loc = findViewById<EditText>(R.id.locCustSign).text.toString()

            database = FirebaseDatabase.getInstance().getReference("Custs")
            val cust = Customer(name,usernm,mail,pass,phone,loc)


            database.child(usernm).setValue(cust).addOnSuccessListener {
                Toast.makeText(this, "Successfully saved" , Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                Toast.makeText(this, "Faaailed" , Toast.LENGTH_SHORT).show()
                }
        }

    }




}