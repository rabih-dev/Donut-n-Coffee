package com.example.donutncoffee

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        doneBtn.setOnClickListener()
        {
            signUpUser()
        }
    }

    fun signUpUser()
    {
        //vendo se escreveu o email
        if(emailEdtTxt_Register.text.toString().isEmpty())
        {
            emailEdtTxt_Register.error = "missing email"
            emailEdtTxt_Register.requestFocus()
            return
        }

        //vendo se o email é valido
       else if(Patterns.EMAIL_ADDRESS.matcher(emailEdtTxt_Register.toString()).matches())
        {
           emailEdtTxt_Register.error = "invalid email"
            emailEdtTxt_Register.requestFocus()
            return
        }

        //vendo se nao falta a senha tbm
        else if(passwordEdtTxt_Register.text.toString().isEmpty())
        {
            passwordEdtTxt_Register.error = "missing password"
            passwordEdtTxt_Register.requestFocus()
            return
        }

        else
        {
            auth.createUserWithEmailAndPassword(emailEdtTxt_Register.text.toString(), passwordEdtTxt_Register.text.toString()).addOnCompleteListener(this)
            {
                task ->
                if(task.isSuccessful)
            {
                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(this,"sign up sucessful",Toast.LENGTH_SHORT).show()
                finish()
            }
                else
                {
                    Toast.makeText(this,"sign up failed. try again later",Toast.LENGTH_SHORT).show()
                }

            }
        }

        fun progressBarDialog()
        {
            val dialog = Dialog(this,android.R.style.Theme_Translucent_NoTitleBar)
            val view = this.layoutInflater.inflate(R.layout.fullscreen_progressbar,null)
            dialog.setContentView(view)
            dialog.setCancelable(false)
            dialog.show()
        }



    }

}
