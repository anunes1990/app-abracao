package com.allisson.appabracao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.allisson.appabracao.ui.listaongs.ListaOngsFragment

class ListaOngs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_ongs_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListaOngsFragment.newInstance())
                .commitNow()
        }
    }
}
