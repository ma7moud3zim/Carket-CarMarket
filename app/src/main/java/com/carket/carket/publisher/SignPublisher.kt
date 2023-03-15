package com.carket.carket.publisher

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.carket.carket.BaseActivity
import com.carket.carket.R
import com.carket.carket.customer.Customer
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignPublisher : BaseActivity() {
    // The initialize of databaseReference important for inserting data
    private lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_publisher)

        val signBtn = findViewById<Button>(R.id.signPub)

        // Handling Sign Button
        signBtn.setOnClickListener{
            val name = findViewById<EditText>(R.id.namePbSign).text.toString()
            val usernm = findViewById<EditText>(R.id.usernamePbSign).text.toString().trim()
            val mail = findViewById<EditText>(R.id.mailPbSign).text.toString()
            val pass = findViewById<EditText>(R.id.passPbSign).text.toString()
            val phone = findViewById<EditText>(R.id.phonePbSign).text.toString()
            val loc = findViewById<EditText>(R.id.locPbSign).text.toString()

            db = FirebaseDatabase.getInstance().getReference("Publishers")
            val pub = Customer(name,usernm,mail,pass,phone,loc)

            db.child(usernm).setValue(pub).addOnSuccessListener {
                Toast.makeText(this, "Welcome! You are signed Up." , Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(this, "Sign up Failed" , Toast.LENGTH_SHORT).show()
                }
        }


    }
}