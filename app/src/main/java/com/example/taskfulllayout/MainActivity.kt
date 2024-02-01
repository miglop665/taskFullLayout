package com.example.taskfulllayout

import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val REQ_CODE = 100
    private lateinit var tiempo: Button
    private lateinit var perfil: ImageButton
    private lateinit var listamusica: ImageButton
    private lateinit var llamar: ImageButton
    private lateinit var bottom_navigation: View
    private lateinit var desplegado: View


    private lateinit var btnDesplegable: ImageButton
    private lateinit var btnDesplegable2: ImageButton

    private lateinit var btnMicro: Button
    private lateinit var botonGoogle: Button
    private lateinit var mp: MediaPlayer
    private lateinit var mp1: MediaPlayer
    private lateinit var mp2: MediaPlayer
    private lateinit var mp3: MediaPlayer
    var flag:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tiempo=findViewById(R.id.botonTiempo)
        btnMicro=findViewById(R.id.btnMicro)
        botonGoogle=findViewById(R.id.botonGoogle)
        perfil=findViewById(R.id.botonImagen)
        listamusica=findViewById(R.id.botonPlay)
        llamar=findViewById(R.id.botonCall)
        bottom_navigation=findViewById(R.id.bottom_navigation)
        desplegado=findViewById(R.id.desplegado)
        btnDesplegable=findViewById(R.id.btnDesplegable)
        btnDesplegable2=findViewById(R.id.btnDesplegable2)


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

        btnMicro.setOnClickListener {

            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hable usted")
            try {
                startActivityForResult(intent, REQ_CODE)
            } catch (a: ActivityNotFoundException) {
                //por si no tuvieramos opcion de micro en nuestro dispositivo
                Toast.makeText(applicationContext, "Repite de nuevo", Toast.LENGTH_SHORT).show()
            }

        }

        botonGoogle.setOnClickListener {

            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hable usted")
            try {
                startActivityForResult(intent, REQ_CODE)
            } catch (a: ActivityNotFoundException) {
                //por si no tuvieramos opcion de micro en nuestro dispositivo
                Toast.makeText(applicationContext, "Repite de nuevo", Toast.LENGTH_SHORT).show()
            }

        }

        btnDesplegable.setOnClickListener {
            if (bottom_navigation.visibility == View.VISIBLE) { bottom_navigation.visibility = View.GONE }
            if (desplegado.visibility == View.GONE) { desplegado.visibility = View.VISIBLE }

        }
        btnDesplegable2.setOnClickListener {
            if (bottom_navigation.visibility == View.GONE) { bottom_navigation.visibility = View.VISIBLE }
            if (desplegado.visibility == View.VISIBLE) { desplegado.visibility = View.GONE }

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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE && resultCode == RESULT_OK){

            val results = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (results != null && results.isNotEmpty()) {
                val spokenText = results[0].toLowerCase()

                // Verificar si la frase contiene "actividad 1"
                if (spokenText.contains("tiempo")) {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                } else  if (spokenText.contains("musica")) {
                            val intent = Intent(this, listamusica::class.java)
                            startActivity(intent)
                        } else
                            if (spokenText.contains("musica")) {
                                val intent = Intent(this, listamusica::class.java)
                                startActivity(intent) }
                            else {
                                 Toast.makeText(applicationContext, "Acción no reconocida", Toast.LENGTH_SHORT).show()
                                }
            }


        }
    }
}