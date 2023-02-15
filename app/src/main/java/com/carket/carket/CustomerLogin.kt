package com.carket.carket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CustomerLogin : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login)


        // Go to SignUp a new Customer
        val goToCusSign = findViewById<Button>(R.id.goToCusSign)
        goToCusSign.setOnClickListener {
            val intent = Intent(this@CustomerLogin, SignCustomer::class.java)
            startActivity(intent)
        }


    }
}