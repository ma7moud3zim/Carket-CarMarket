package com.carket.carket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PublisherLogin : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publisher_login)


        // Go to SignUp a new Publisher
        val goToCusSign = findViewById<Button>(R.id.goToPubSign)
        goToCusSign.setOnClickListener {
            val intent = Intent(this@PublisherLogin, SignPublisher::class.java)
            startActivity(intent)
        }

    }
}