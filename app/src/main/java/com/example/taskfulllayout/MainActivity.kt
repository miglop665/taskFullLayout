package com.example.taskfulllayout

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private lateinit var tiempo: Button
    private lateinit var perfil: ImageButton
    private lateinit var listamusica: ImageButton
    private lateinit var llamar: ImageButton
    private lateinit var mp: MediaPlayer
    private lateinit var mp1: MediaPlayer
    private lateinit var mp2: MediaPlayer
    private lateinit var mp3: MediaPlayer
    var flag:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tiempo=findViewById(R.id.botonTiempo)
        perfil=findViewById(R.id.botonImagen)
        listamusica=findViewById(R.id.botonPlay)
        llamar=findViewById(R.id.botonCall)


        tiempo.setOnClickListener {
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(intent)
        }

        perfil.setOnClickListener {
            val intent = Intent(this@MainActivity,MainActivity3::class.java)
            startActivity(intent)
        }

        llamar.setOnClickListener {
            val intent = Intent(this@MainActivity,MainActivity4::class.java)
            startActivity(intent)
        }

        listamusica.setOnClickListener {
            var arrayCanciones = arrayOf(R.raw.cancion1,R.raw.cancion2,R.raw.cancion3)
            mp1= MediaPlayer.create(this, arrayCanciones[0])
            mp2= MediaPlayer.create(this, arrayCanciones[0])
            mp3= MediaPlayer.create(this, arrayCanciones[0])
            if(mp1.isPlaying){
                mp1.stop()
            }else{
                if(mp2.isPlaying){
                    mp2.stop()
                }else{
                    mp3.stop()
                }
            }

            mp= MediaPlayer.create(this, arrayCanciones[(0..2).random()])
            mp.start()
        }
    }
}