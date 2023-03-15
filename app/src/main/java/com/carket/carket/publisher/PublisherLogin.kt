package com.carket.carket.publisher

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.carket.carket.BaseActivity
import com.carket.carket.R
import com.carket.carket.publisher.HomePublisher
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PublisherLogin : BaseActivity() {
    private lateinit var db : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publisher_login)


        // Go to SignUp a new Publisher
        val goToPubSign = findViewById<Button>(R.id.goToPubSign)
        goToPubSign.setOnClickListener {
            val intent = Intent(this@PublisherLogin, SignPublisher::class.java)
            startActivity(intent)
        }

        val logn = findViewById<Button>(R.id.loginpub)
        logn.setOnClickListener{
            val usernm = findViewById<EditText>(R.id.usernamePb).text.toString().trim()
            val pass = findViewById<EditText>(R.id.passPb).text.toString().trim()
            if(usernm.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Please Type the username and the password", Toast.LENGTH_SHORT).show()
            }else{
                check(usernm , pass)
            }
        }
    }
    private fun check(userName:String , pass:String){
        db = FirebaseDatabase.getInstance().getReference("Publishers")
        db.child(userName).get().addOnSuccessListener {
            if(it.exists()){
                val fpass = it.child("pass").value

                if(pass == fpass){
                    val intent = Intent(this@PublisherLogin, HomePublisher::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Incorrect Username and Password.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "The Username doesn't exist. You need to sign up first.", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Failed.", Toast.LENGTH_SHORT).show()
        }


    }
}