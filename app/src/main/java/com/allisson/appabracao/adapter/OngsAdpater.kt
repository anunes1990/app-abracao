package com.allisson.appabracao.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allisson.appabracao.DetalheOng
import com.allisson.appabracao.R
import com.allisson.appabracao.models.Ong
import kotlinx.android.synthetic.main.item.view.*

class OngsAdpater(
    private val myDataset: List<Ong>,
    private val context: Context) :
    RecyclerView.Adapter<OngsAdpater.MyViewHolder>() {
    class MyViewHolder(val viewRoot: View) : RecyclerView.ViewHolder(viewRoot)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OngsAdpater.MyViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(textView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewRoot.txt_detail.text = "${myDataset[position].nome} - ${myDataset[position].email}"

        holder.viewRoot.setOnClickListener {
            val intent = Intent(context, DetalheOng::class.java)
            intent.putExtra("ong", myDataset[position])
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = myDataset.size;
}