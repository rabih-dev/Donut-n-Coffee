package com.example.donutncoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackView
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val lista = mutableListOf<Project>()
        var avatar = (R.drawable.avatar_android)


        for (i in 1..10)
        {
            lista.add(Project("Doidera", "o lokinho meu locuras locas na sua televisao", true, avatar))
        }


        viewAdapter = CardStackAdapter(lista)
        viewManager = CardStackLayoutManager(this)
        card_stack_view.adapter = viewAdapter
         card_stack_view.layoutManager = viewManager

    }


}
