package com.example.donutncoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_mensagens.*

class Mensagens : AppCompatActivity()   {


    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lista  = mutableListOf<HolderMensages>()
        var avatar = (R.drawable.ic_launcher_background)

        for(i in 1..100){
            lista.add(HolderMensages("João $i",fotoPerfil = avatar, hora = "00:00 $i" , mensagem = "Manda Nudes $i"))
        }

        viewAdapter = MensagemAdapter(lista)
        viewManager = LinearLayoutManager(this)
        rvLista.adapter = viewAdapter
        rvLista.layoutManager = viewManager

    }

}
