package com.example.taskfulllayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity4 : AppCompatActivity() {
    private lateinit var volver: ImageButton
    private lateinit var llamar: ImageButton
    private lateinit var numero: TextView
    private lateinit var boton0: Button
    private lateinit var boton1: Button
    private lateinit var boton2: Button
    private lateinit var boton3: Button
    private lateinit var boton4: Button
    private lateinit var boton5: Button
    private lateinit var boton6: Button
    private lateinit var boton7: Button
    private lateinit var boton8: Button
    private lateinit var boton9: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        volver=findViewById(R.id.botonVolver)
        llamar=findViewById(R.id.botonLlamar)
        numero=findViewById(R.id.txvNumero)
        boton0=findViewById(R.id.boton0)
        boton1=findViewById(R.id.boton1)
        boton2=findViewById(R.id.boton2)
        boton3=findViewById(R.id.boton3)
        boton4=findViewById(R.id.boton4)
        boton5=findViewById(R.id.boton5)
        boton6=findViewById(R.id.boton6)
        boton7=findViewById(R.id.boton7)
        boton8=findViewById(R.id.boton8)
        boton9=findViewById(R.id.boton9)




        boton0.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"0"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }

        }
        boton1.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"1"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }
        boton2.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"2"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }
        boton3.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"3"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }
        boton4.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"4"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }
        boton5.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"5"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }
        boton6.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"6"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }
        boton7.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"7"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }
        boton8.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"8"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }
        boton9.setOnClickListener {
            if(numero.text.toString().length<9) {
                numero.text=numero.text.toString()+"9"
            }else {
                Toast.makeText(this,"Numero de digitos maximos alcanzado",Toast.LENGTH_SHORT).show()
            }
        }



        volver.setOnClickListener {
            val intent = Intent(this@MainActivity4,MainActivity::class.java)
            startActivity(intent)
        }

        llamar.setOnClickListener {
            Toast.makeText(this,"No dispone de ninguna red movil ahora mismo",Toast.LENGTH_LONG).show()
        }

    }
}