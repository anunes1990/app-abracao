package com.allisson.appabracao.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    var logado: MutableLiveData<Boolean> = MutableLiveData()
    fun login(email: String, senha: String) {
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    logado.value = true
                } else {
                    Log.d("[[LOGIN ERROR]]", task.exception.toString())
                    logado.value = false
                }
            }
    }
}
