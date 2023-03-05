package com.carket.carket.customer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.carket.carket.BaseActivity
import com.carket.carket.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CustomerLogin : BaseActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login)


        // Go to SignUp a new Customer
        val goToCusSign = findViewById<Button>(R.id.goToCusSign)
        goToCusSign.setOnClickListener {
            val intent = Intent(this@CustomerLogin, SignCustomer::class.java)
            startActivity(intent)
        }

        val logn = findViewById<Button>(R.id.loginCus)
        logn.setOnClickListener{
            val usernm = findViewById<EditText>(R.id.usernameIn).text.toString().trim()
            val pass = findViewById<EditText>(R.id.passIn).text.toString().trim()
            if(usernm.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Please Type the username and the password", Toast.LENGTH_SHORT).show()
            }else{
                check(usernm , pass);
            }
        }
    }
    private fun check(userName:String , pass:String){
        database = FirebaseDatabase.getInstance().getReference("Custs")
        database.child("sharmy").get().addOnSuccessListener {
            if(it.exists()){
                val fpass = it.child("pass").value

                if(pass.equals(fpass)){
                    val intent = Intent(this@CustomerLogin, HomeActivityCust::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "There are wrong on username or password.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "The username doesn't exit please sign up first.", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Failed.", Toast.LENGTH_SHORT).show()
        }
    }
}