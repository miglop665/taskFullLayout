package com.example.taskfulllayout

import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
/*import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions*/
import kotlinx.coroutines.launch

class MainActivity5 : AppCompatActivity()/*,  OnMapReadyCallback*/ {

    //DECLARACION DE VARIABLES
    private lateinit var volver: ImageButton
    private val locationService: LocationService = LocationService()
    //private lateinit var mapView: MapView
    private lateinit var text: TextView
    private var userLocation: Location? = null
    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ASIGNACION CON LOS ELEMENTOS DE LA ACTIVIDAD
        setContentView(R.layout.activity_main5)
        Log.d(TAG, "Comienzo Actividad")
        volver = findViewById(R.id.botonVolver)
        //mapView = findViewById(R.id.mapView)
        text = findViewById(R.id.text)
        //mapView.onCreate(savedInstanceState)
        //mapView.getMapAsync(this)

        //ASIGNACION DE LAS ULTIMAS LATITUDES Y LONGITUDES ASIGNADAS
        lifecycleScope.launch {
            val result: Location? = locationService.getUserLocation(this@MainActivity5)
            if (result != null) {
                text.text = "Latitud ${result.latitude} y longitud ${result.longitude}"
            }
        }

        //CONTROL DEL BOTON DE VOLVER
        volver.setOnClickListener {
            val intent = Intent(this@MainActivity5, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


/*

    CODIGO PARA LA ASIGNACION DE LA VISTA DEL MAPA CON LAS ULTIMAS COORDENADAS ASIGNADAS
    override fun onMapReady(googleMap: GoogleMap) {
        Log.d(TAG, "Creacion del mapa")
        // Asegúrate de tener los permisos necesarios para acceder a la ubicación
        if (userLocation != null) {
            val userLatLng = LatLng(userLocation!!.latitude, userLocation!!.longitude)
            googleMap.addMarker(MarkerOptions().position(userLatLng).title("Ubicación del usuario"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLatLng, 15f))
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }*/
