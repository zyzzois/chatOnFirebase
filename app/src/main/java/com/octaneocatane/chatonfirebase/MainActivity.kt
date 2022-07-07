package com.octaneocatane.chatonfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.octaneocatane.chatonfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")
        binding.buttonSend.setOnClickListener {
            myRef.setValue(binding.editMessage.text.toString())
        }
        onChangeListener(myRef)
    }

    //в функцию мы передаем путь на котором будем слушать изменения
    private fun onChangeListener(databaseReference: DatabaseReference) {
        databaseReference.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                binding.apply {
                    rcView.append("\nRuslan: ${snapshot.value.toString()}")
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

}