package com.example.donutncoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackView
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val lista = mutableListOf<Project>()
        var avatar = (R.drawable.avatar_android)

        for (i in 1..10)
        {
            lista.add(Project("Doidera", "o lokinho meu locuras locas na sua televisao", true, avatar))
        }

         card_stack_view.layoutManager = CardStackLayoutManager(this)
         card_stack_view.adapter = CardStackAdapter(lista)
    }


}
