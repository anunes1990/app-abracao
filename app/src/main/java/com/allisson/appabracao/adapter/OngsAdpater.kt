package com.allisson.appabracao.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allisson.appabracao.R
import com.allisson.appabracao.models.Ong
import kotlinx.android.synthetic.main.item.view.*

class OngsAdpater(private val myDataset: List<Ong>) :
    RecyclerView.Adapter<OngsAdpater.MyViewHolder>() {
    class MyViewHolder(val viewRoot: View) : RecyclerView.ViewHolder(viewRoot)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OngsAdpater.MyViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(textView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewRoot.txt_detail.text = "${myDataset[position].nome} - ${myDataset[position].email}"
    }

    override fun getItemCount() = myDataset.size;
}