package com.allisson.appabracao.ui.usuario

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.allisson.appabracao.Login
import com.allisson.appabracao.R
import com.allisson.appabracao.databinding.UsuarioFragmentBinding
import com.allisson.appabracao.models.Usuario
import kotlinx.android.synthetic.main.usuario_fragment.view.*

class UsuarioFragment : Fragment() {

    companion object {
        fun newInstance() = UsuarioFragment()
    }

    private lateinit var viewModel: UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.usuario_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        val binding: UsuarioFragmentBinding =
            DataBindingUtil.setContentView(activity!!, R.layout.usuario_fragment)
        binding.viewModel = viewModel

        binding.btnCancelar.setOnClickListener {
            activity!!.finish()
            startActivity(Intent(context, Login::class.java))
        }

        binding.btnSalvar.setOnClickListener {
            if (binding.txtNome.text.isEmpty() || binding.txtEmail.text.isEmpty() ||
                binding.txtTelefone.text.isEmpty() || binding.txtSenha.text.isEmpty() ||
                binding.txtConfirmacao.text.isEmpty()
            ) {
                Toast.makeText(
                    context,
                    "Os campos são obrigatórios preencha-os",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (binding.txtSenha.text.toString() == binding.txtConfirmacao.text.toString()) {
                    viewModel.usuario = Usuario(
                        "",
                        binding.txtNome.text.toString(),
                        binding.txtEmail.text.toString(),
                        binding.txtTelefone.text.toString(),
                        binding.txtSenha.text.toString()
                    )
                    viewModel.cadastrarUsuario()
                } else {
                    binding.txtSenha.text = null
                    binding.txtConfirmacao.text = null
                    Toast.makeText(
                        context,
                        "As senhas digitadas não são iguais",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        viewModel.registrado.observe(viewLifecycleOwner, Observer {
            viewModel.registrado.value?.let {
                if (it) {
                    activity!!.finish()
                    Toast.makeText(context, "Usuário registrado com sucesso", Toast.LENGTH_LONG).show()
                    startActivity(Intent(context, Login::class.java))
                } else {
                    Toast.makeText(context, "E-mail já cadastrado, verifique e tente novamente", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
