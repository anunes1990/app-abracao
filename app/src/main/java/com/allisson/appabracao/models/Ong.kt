package com.allisson.appabracao.models

import java.io.Serializable

data class Ong(
    val nome: String,
    val endereco: String,
    val qtqPessoas: Int,
    val foto: String,
    val telefone: String,
    val email: String,
    val site: String
): Serializable