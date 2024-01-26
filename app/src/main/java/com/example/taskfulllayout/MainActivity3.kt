package com.example.taskfulllayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity3 : AppCompatActivity() {
    private lateinit var volver: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        volver=findViewById(R.id.botonVolver)


        volver.setOnClickListener {
            val intent = Intent(this@MainActivity3,MainActivity::class.java)
            startActivity(intent)
        }
    }
}