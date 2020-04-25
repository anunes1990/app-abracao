package com.allisson.appabracao.models

import java.io.Serializable

data class Ong(
    val id: String,
    val nome: String,
    val endereco: String,
    val qtdPessoas: String,
    val foto: String,
    val telefone: String,
    val email: String,
    val site: String
): Serializable