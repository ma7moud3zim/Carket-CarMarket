package com.carket.carket.customer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.carket.carket.BaseActivity
import com.carket.carket.R

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