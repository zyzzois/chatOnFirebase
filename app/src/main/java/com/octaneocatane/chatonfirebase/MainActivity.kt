package com.octaneocatane.chatonfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message").child("Ruslan")
        myRef.setValue("Hello, World!")
    }
}