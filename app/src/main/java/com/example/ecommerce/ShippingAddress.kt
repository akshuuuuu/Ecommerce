package com.example.ecommerce

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_shipping_address.*

class ShippingAddress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping_address)
        btnConfirm.setOnClickListener {
            var verifyUrl = "http://192.168.43.182/verify_order.php?email=${Person.email}"

            var requestQ = Volley.newRequestQueue(this@ShippingAddress)
            var stringRequest = StringRequest(Request.Method.GET,verifyUrl, Response.Listener {
                response ->
                var intent = Intent(this, FinalizeShoppingActivity::class.java)
                Toast.makeText(this, response, Toast.LENGTH_LONG).show()
                intent.putExtra("LATEST_INVOICE_NUMBER", response)
                startActivity(intent)

            }, Response.ErrorListener {
                error ->

            })
            requestQ.add(stringRequest)
        }
    }
}