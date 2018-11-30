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

/**
 * Checa se o Gps está ativo. Chama o dialogo de sair do aplicativo caso não esteja
 *
 * @property activity usada para chamar o serviço que confere se o gps está ativo
 * @property body função que é chamada caso gps esteja ativo
 */
fun checarGpsAtivo(activity: Activity, body: () -> Unit = {}){

    val gpsAtivo = isGpsAtivo(activity)
    if(!gpsAtivo){
        Log.i("script2", activity.getString(R.string.mensagem_gps_inativo))
    }
    else {
        body()
    }
}

