package com.example.ecommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sign_up_layout.*

class SignUpLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_layout)

        btnSignup.setOnClickListener {
            if (edtSignupPass.text.toString().equals(edtSignupRePass.text.toString())) {

                val signUpURL= "http://192.168.43.182/join_new_user.php?email=" +
                        edtSignupEmail.text.toString() +
                        "&username=" +
                        edtSignupUsername.text.toString()+
                        "&pass=" + edtSignupPass.text.toString()
                val requestQ = Volley.newRequestQueue(this@SignUpLayout)
                val stringRequest = StringRequest(Request.Method.GET, signUpURL
                    , Response.Listener { response ->

                        if (response.equals("A user with this Email Address already exists ")) {
                            val dialogBuilder = AlertDialog.Builder(this)
                            dialogBuilder.setTitle("Message")
                            dialogBuilder.setMessage(response)
                            dialogBuilder.create().show()


                        } else {

//                            val dialogBuilder = AlertDialog.Builder(this)
//                            dialogBuilder.setTitle("Message")
//                            dialogBuilder.setMessage(response)
//                            dialogBuilder.create().show()
                            Person.email= edtSignupEmail.text.toString()

                            Toast.makeText(this@SignUpLayout,response,Toast.LENGTH_SHORT).show()
                            val homeIntent= Intent(this@SignUpLayout,HomeScreen::class.java)
                            startActivity(homeIntent)
                        }

                    }, Response.ErrorListener { error ->

                        val dialogBuilder = AlertDialog.Builder(this)
                        dialogBuilder.setTitle("Message")
                        dialogBuilder.setMessage(error.message)
                        dialogBuilder.create().show()

                    })

                requestQ.add(stringRequest)


            } else {
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Alert")
                dialogBuilder.setMessage("Password Mismatch")
                dialogBuilder.create().show()
            }
        }
        btnSignup.setOnClickListener {
            finish()
        }
    }
}
