package com.carket.carket

import android.content.Intent
import android.os.Bundle


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /* Check if the user logged in
                 True: fetch data and show it in home activity
                 False: redirect to chooser activity
        */

        // redirecting to the chooser activity "temporarily"
        val intent = Intent(this@SplashActivity, ChooserActivity::class.java)
        startActivity(intent)



    }

}