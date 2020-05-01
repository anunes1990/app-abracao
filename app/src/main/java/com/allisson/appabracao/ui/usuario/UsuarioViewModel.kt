package com.allisson.appabracao.ui.usuario

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.allisson.appabracao.models.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class UsuarioViewModel : ViewModel() {
    var usuario: Usuario? = null
    var db = FirebaseFirestore.getInstance().collection("usuarios")
    var registrado: MutableLiveData<Boolean> = MutableLiveData()

    fun cadastrarUsuario() {
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(usuario!!.email, usuario!!.senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val u = hashMapOf(
                        "uid" to auth.currentUser!!.uid,
                        "nome" to usuario!!.nome,
                        "email" to usuario!!.email,
                        "telefone" to usuario!!.telefone,
                        "senha" to usuario!!.senha
                    )
                    db.add(u)
                    registrado.value = true
                } else {
                    Log.d("[[ERRO NOVO USUARIO]]", task.exception.toString())
                    registrado.value = false
                }
            }
    }
}
