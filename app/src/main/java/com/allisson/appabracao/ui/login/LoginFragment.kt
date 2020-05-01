package com.allisson.appabracao.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.allisson.appabracao.ListaOngs
import com.allisson.appabracao.R
import com.allisson.appabracao.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val binding: LoginFragmentBinding = DataBindingUtil.setContentView(activity!!, R.layout.login_fragment)
        binding.viewModel = viewModel


        binding.btnLogin.setOnClickListener {
            if (binding.txtEmail.text.isEmpty() || binding.txtSenha.text.isEmpty()) {
                Toast.makeText(
                    context,
                    "Os campos são obrigatórios preencha-os",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                viewModel.login(binding.txtEmail.text.toString(), binding.txtSenha.text.toString())
                viewModel.logado.observe(viewLifecycleOwner, Observer {
                    if (it) {
                        activity!!.finish();
                        startActivity(Intent(context, ListaOngs::class.java))
                    } else {
                        binding.txtEmail.text = null
                        binding.txtSenha.text = null
                        Toast.makeText(
                            context,
                            "Usuário sem permissão ou dados incorretos, verifique e tente novamente",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
            }
        }
    }

}
