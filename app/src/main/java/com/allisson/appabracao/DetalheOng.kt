package com.allisson.appabracao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.allisson.appabracao.models.Ong
import com.allisson.appabracao.ui.detalheong.DetalheOngFragment

class DetalheOng : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhe_ong_activity)

        val ong = intent.getSerializableExtra("ong") as Ong

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetalheOngFragment.newInstance(ong))
                .commitNow()
        }
    }
}
