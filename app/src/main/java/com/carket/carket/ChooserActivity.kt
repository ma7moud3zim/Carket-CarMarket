package com.carket.carket

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class ChooserActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooser)

        // Handling the Button of CustomerLogin
        val goToCus = findViewById<Button>(R.id.goToCus)
        goToCus.setOnClickListener {
            val intent = Intent(this@ChooserActivity, CustomerLogin::class.java)
            startActivity(intent)
        }


        // Handling the Button of PublisherLogin
        val goToPub = findViewById<Button>(R.id.goToPub)
        goToPub.setOnClickListener {
            val intent = Intent(this@ChooserActivity, PublisherLogin::class.java)
            startActivity(intent)
        }

    }



}