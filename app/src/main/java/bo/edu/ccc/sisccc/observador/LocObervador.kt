package bo.edu.ccc.sisccc.observador

import android.Manifest
import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.pm.PackageManager
import android.location.Location
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import bo.edu.ccc.sisccc.utils.GecnLog
import bo.edu.ccc.sisccc.utils.GecnLog.Companion.d

// ---- Google Maps Localizacion ----
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class LocObervador(var activity: Activity): LifecycleObserver {
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeListener(){
        // Comprobar Permisos
        // Recoger la ultima actualizacion de la localizacion

        if(ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if(!ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION)){
                //Perdira los permisos necesarios al usuario mediante un dialogo estandar del sistema
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),1)
            }
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
            GecnLog.d("Latitud: ${location?.latitude}")
            GecnLog.d("Longitud: ${location?.longitude}")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseListener(){
        d("Estamos en el listener de onPause")
    }

}