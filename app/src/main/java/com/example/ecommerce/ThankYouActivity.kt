package com.example.ecommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_thank_you.*

class ThankYouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)

        btnContinue.setOnClickListener {
            var intent = Intent(this,HomeScreen::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            finish()
            System.exit(0)
        }
    }
}