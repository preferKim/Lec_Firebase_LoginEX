package com.preferkim.lec_firebase_loginex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Firebase. 뒤의 'auth'가 import되지 않는 문제 (Unresolved reference: auth)
        auth = Firebase.auth

        var btnAnonymousLogin = findViewById<Button>(R.id.btnAnonymousLogin)
        btnAnonymousLogin.setOnClickListener {

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(
                            baseContext, auth.currentUser.uid.toString(),
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {

                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

        }
    }
}