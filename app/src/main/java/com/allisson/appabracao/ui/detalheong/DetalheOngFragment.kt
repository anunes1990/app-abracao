package com.allisson.appabracao.ui.detalheong

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.allisson.appabracao.R
import com.allisson.appabracao.databinding.DetalheOngFragmentBinding
import com.allisson.appabracao.models.Ong
import com.squareup.picasso.Picasso

class DetalheOngFragment : Fragment() {

    companion object {
        fun newInstance(ong: Ong): DetalheOngFragment {
            val f = DetalheOngFragment()
            val args = Bundle()
            args.putSerializable("ong", ong)
            f.arguments = args
            return f
        }
    }

    private lateinit var viewModel: DetalheOngViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detalhe_ong_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetalheOngViewModel::class.java)
        val binding: DetalheOngFragmentBinding = DataBindingUtil.setContentView(
            activity!!, R.layout.detalhe_ong_fragment
        )
        binding.viewModel = viewModel
        viewModel.ong = arguments?.getSerializable("ong") as Ong

    }

}
