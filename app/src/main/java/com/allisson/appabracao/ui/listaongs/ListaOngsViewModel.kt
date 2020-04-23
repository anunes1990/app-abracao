package com.allisson.appabracao.ui.listaongs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.allisson.appabracao.models.Ong

class ListaOngsViewModel : ViewModel() {
    //var ongs: MutableList<Ong> = ArrayList();
    var ongs: MutableLiveData<List<Ong>> = MutableLiveData<List<Ong>>();

    fun getOngs(){

        val ong1 = Ong(
            "Ong TESTE 1",
            "Rua Correa de Mello, 1045",
            25,
            "foto1",
            "(51) 3365-6812",
            "ong1@ong1.com.br",
            "ong1.com.br"
        )

        val ong2 = Ong(
            "Ong TESTE 2",
            "Rua Correa de Mello, 1045",
            325,
            "foto2",
            "(51) 3365-7079",
            "ong2@ong2.com.br",
            "ong2.com.br"
        )

        val tempOngs: MutableList<Ong> = ArrayList();
        tempOngs.add(ong1)
        tempOngs.add(ong2)

        ongs.value = tempOngs;
    }

}
