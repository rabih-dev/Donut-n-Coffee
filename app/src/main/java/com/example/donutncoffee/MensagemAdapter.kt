package com.example.donutncoffee

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_mensagens.view.*
import kotlinx.android.synthetic.main.listmensagens.view.*

class MensagemAdapter (var myDataset: List<HolderMensages>):RecyclerView.Adapter<MensagemAdapter.MyViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.activity_mensagens,parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, pos: Int) {
        viewHolder.nome.text = myDataset[pos].nome
        viewHolder.sobrenome.text = myDataset[pos].mensagem
        viewHolder.avatar.setImageResource(myDataset[pos].fotoPerfil)
    }


    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var nome = itemView.nomeMensagem
        var sobrenome = itemView.Mensagem
        var avatar = itemView.fotoPerfilMensagem
    }
}