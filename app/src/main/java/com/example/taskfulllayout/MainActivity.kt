package com.example.taskfulllayout

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private lateinit var tiempo: Button
    private lateinit var perfil: ImageButton
    private lateinit var listamusica: CardView
    private lateinit var llamar: CardView
    private lateinit var mp: MediaPlayer
    private lateinit var txv1: TextView
    private lateinit var txv2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tiempo=findViewById(R.id.botonTiempo)
        perfil=findViewById(R.id.botonImagen)
        listamusica=findViewById(R.id.CVbotonPlay)
        llamar=findViewById(R.id.CVbotonCall)
        txv1=findViewById(R.id.textView6)
        txv2=findViewById(R.id.textView7)


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

        var arrayCanciones = arrayOf(R.raw.barbie_girl,R.raw.call_me_maybe,R.raw.avicii_wake_me_up)
        mp= MediaPlayer.create(this, arrayCanciones.random())
        listamusica.setOnClickListener {
            if(mp.isPlaying){
                mp.stop()
            }else{
                var cancion = arrayCanciones.random()
                mp= MediaPlayer.create(this, cancion)
                mp.start()
                txv1.text= resources.getResourceEntryName(cancion)
                txv2.text=(mp.duration/60000).toString()+" mins"
            }
        }
    }
}