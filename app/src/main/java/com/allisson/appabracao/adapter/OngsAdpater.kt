package com.allisson.appabracao.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.allisson.appabracao.DetalheOng
import com.allisson.appabracao.R
import com.allisson.appabracao.models.Ong
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class OngsAdpater(
    private val myDataset: List<Ong>,
    private val context: Context) :
    RecyclerView.Adapter<OngsAdpater.MyViewHolder>() {
    lateinit var imageView: ImageView
    class MyViewHolder(val viewRoot: View) : RecyclerView.ViewHolder(viewRoot)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OngsAdpater.MyViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(textView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewRoot.txt_nome.text = myDataset[position].nome
        imageView = holder.viewRoot.iv_ong;
        loadImageFromUrl(myDataset[position].foto)
        holder.viewRoot.setOnClickListener {
            val intent = Intent(context, DetalheOng::class.java)
            intent.putExtra("ong", myDataset[position])
            context.startActivity(intent)
        }
    }

    private fun loadImageFromUrl(url: String) {
        Picasso.get().load(url).resize(300, 300)
            .centerCrop().into(imageView)
    }

    override fun getItemCount() = myDataset.size;
}