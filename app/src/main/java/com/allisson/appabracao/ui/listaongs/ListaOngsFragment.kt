package com.allisson.appabracao.ui.listaongs

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.allisson.appabracao.R
import com.allisson.appabracao.adapters.OngsAdpater
import kotlinx.android.synthetic.main.lista_ongs_fragment.*

class ListaOngsFragment : Fragment() {
    companion object {
        fun newInstance() = ListaOngsFragment()
    }

    private lateinit var viewModel: ListaOngsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.lista_ongs_fragment, container, false)
    }

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListaOngsViewModel::class.java)
        viewManager = LinearLayoutManager(activity)

        rvOngs.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }

        viewModel.ongs.observe(viewLifecycleOwner, Observer {
            viewModel.ongs.value?.let {
                viewAdapter = OngsAdpater(it, activity as Context)
                rvOngs.adapter = viewAdapter
            }
        })
        viewModel.getOngs();
    }
}
