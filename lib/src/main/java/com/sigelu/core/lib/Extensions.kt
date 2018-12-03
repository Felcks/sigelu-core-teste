package com.sigelu.core.lib

import android.app.Activity
import android.content.Context
import android.location.LocationManager
import android.util.Log
import java.util.logging.Logger

/**
 * Retorna true se o gps está ativo, false se não.
 *
 * @property activity usada para chamar o serviço que confere se o gps está ativo
 */
fun isGpsAtivo(activity: Activity): Boolean{

    val locationManager = activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    var gpsAtivo = false
    try{
        gpsAtivo =  locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }
    catch (e: Exception){}

    return gpsAtivo
}

