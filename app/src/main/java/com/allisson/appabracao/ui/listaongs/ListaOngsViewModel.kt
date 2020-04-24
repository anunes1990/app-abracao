package com.allisson.appabracao.ui.listaongs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.allisson.appabracao.models.Ong
import com.google.firebase.firestore.FirebaseFirestore

class ListaOngsViewModel : ViewModel() {
    var ongs: MutableLiveData<List<Ong>> = MutableLiveData<List<Ong>>()
    val db = FirebaseFirestore.getInstance()
    val tempOngs: MutableList<Ong> = ArrayList();

    fun getOngs() {
        db.collection("ongs").get().addOnSuccessListener { result ->
            for (ong in result) {
                tempOngs.add(Ong(
                    ong.id,
                    ong.data["nome"].toString(),
                    ong.data["endereco"].toString(),
                    ong.data["qtdPessoas"].toString().toInt(),
                    ong.data["foto"].toString(),
                    ong.data["telefone"].toString(),
                    ong.data["email"].toString(),
                    ong.data["site"].toString()
                ))
            }
            ongs.value = tempOngs;
        }
    }
}
