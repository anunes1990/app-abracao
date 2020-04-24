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
            "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSxdIgc7wBcx2YTCGi9EaYn6EqZtLN3-ZBn_oakGP5Qzr7m4A57&usqp=CAU",
            "(51) 3365-6812",
            "ong1@ong1.com.br",
            "ong1.com.br"
        )

        val ong2 = Ong(
            "Ong TESTE 2",
            "Rua Correa de Mello, 1045",
            325,
            "https://i1.wp.com/www.blogueirosdasaude.org.br/wp-content/uploads/2017/12/simbolo.jpg?fit=458%2C218&ssl=1",
            "(51) 3365-7079",
            "ong2@ong2.com.br",
            "ong2.com.br"
        )

        val ong3 = Ong(
            "Ong TESTE 3",
            "Rua Correa de Mello, 1045",
            25,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSxdIgc7wBcx2YTCGi9EaYn6EqZtLN3-ZBn_oakGP5Qzr7m4A57&usqp=CAU",
            "(51) 3365-6812",
            "ong1@ong1.com.br",
            "ong1.com.br"
        )

        val ong4 = Ong(
            "Ong TESTE 4",
            "Rua Correa de Mello, 1045",
            325,
            "https://i1.wp.com/www.blogueirosdasaude.org.br/wp-content/uploads/2017/12/simbolo.jpg?fit=458%2C218&ssl=1",
            "(51) 3365-7079",
            "ong2@ong2.com.br",
            "ong2.com.br"
        )

        val tempOngs: MutableList<Ong> = ArrayList();
        tempOngs.add(ong1)
        tempOngs.add(ong2)
        tempOngs.add(ong3)
        tempOngs.add(ong4)

        ongs.value = tempOngs;
    }

}
