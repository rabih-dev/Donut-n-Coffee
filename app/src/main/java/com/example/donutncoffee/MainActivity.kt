package com.example.donutncoffee

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    //Login Script

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        //Componentes
        val finishBtn = findViewById<Button>(R.id.finishBtn)
        val usernameEdtTxt = findViewById<EditText>(R.id.usernameEdtTxt)
        val passwordEdtTxt = findViewById<EditText>(R.id.passwordEdtTxt)

        //Usuario que deu
        var inputUsername:String = ""
        var inputAge:Int = 0
        var inputPassword:String = ""

        fun txtToInput()
        {
            inputUsername = usernameEdtTxt.text.toString()
            inputPassword =passwordEdtTxt.text.toString()
        }

        finishBtn.setOnClickListener()
        {
            txtToInput()
            if (inputUsername == "" || inputPassword == "")
            {
                Toast.makeText(this,"por favor, preencha tudo",Toast.LENGTH_LONG).show()
            }

            else
            {
                if(inputAge < 18)
                {
                    Toast.makeText(this,"você é jovem demais",Toast.LENGTH_LONG).show()
                }

                else
                {
                    Toast.makeText(this,"você está numa boa epoca da sua vida",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}