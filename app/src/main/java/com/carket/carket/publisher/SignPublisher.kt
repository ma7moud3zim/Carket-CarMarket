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
    private lateinit var database : DatabaseReference

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

            database = FirebaseDatabase.getInstance().getReference("Publisher")
            val pub = Customer(name,usernm,mail,pass,phone,loc)


            database.child(usernm).setValue(pub).addOnSuccessListener {
                Toast.makeText(this, "Successfully saved" , Toast.LENGTH_SHORT).show()

                // Clearing the EditTexts should changed to the home activity and show text
                // that saying Welcome to our application or something like that
                findViewById<EditText>(R.id.namePbSign).getText().clear()
                findViewById<EditText>(R.id.usernamePbSign).getText().clear()
                findViewById<EditText>(R.id.mailPbSign).getText().clear()
                findViewById<EditText>(R.id.passPbSign).getText().clear()
                findViewById<EditText>(R.id.phonePbSign).getText().clear()
                findViewById<EditText>(R.id.locPbSign).getText().clear()
            }
                .addOnFailureListener{
                    Toast.makeText(this, "Faaailed" , Toast.LENGTH_SHORT).show()
                }

        }


    }
}