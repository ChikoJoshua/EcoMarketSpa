package com.example.ecomarketapp

import android.app.Application
import android.util.Log

class EcoMarketApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // Aquí se inicializan componentes globales de la app
        Log.d("EcoMarketApp", "Aplicación iniciada correctamente ✅")
    }
}
