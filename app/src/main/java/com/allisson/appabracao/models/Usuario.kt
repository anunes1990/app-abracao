package com.allisson.appabracao.models

import java.io.Serializable

data class Usuario (
    var uid: String,
    var nome: String,
    var email: String,
    var telefone: String,
    var senha: String
): Serializable