package com.allisson.appabracao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.allisson.appabracao.ui.usuario.UsuarioFragment

class Usuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.usuario_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UsuarioFragment.newInstance())
                .commitNow()
        }
    }
}
