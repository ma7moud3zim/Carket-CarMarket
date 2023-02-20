package com.carket.carket.publisher

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.carket.carket.BaseActivity
import com.carket.carket.R

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