package com.example.donutncoffee

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    //Login Script

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        registerBtn.setOnClickListener()
        {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        loginBtn.setOnClickListener()
        {
            userLogin()
        }
    }

    fun updateUI(currentUser : FirebaseUser?)
    {
        if(currentUser != null)
        {
            startActivity(Intent((this),DashboardActivity::class.java))
            Toast.makeText(this,"sign in sucessful",Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this,"sign in failed",Toast.LENGTH_SHORT).show()
        }
    }

    fun userLogin()
    {
        //vendo se escreveu o email
        if(emailEdtTxt.text.toString().isEmpty())
        {
            emailEdtTxt_Register.error = "missing email"
            emailEdtTxt_Register.requestFocus()
            return
        }

        //vendo se o email é valido
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailEdtTxt.toString()).matches())
        {
            emailEdtTxt_Register.error = "invalid email"
            emailEdtTxt_Register.requestFocus()
            return
        }

        //vendo se nao falta a senha tbm
        else if(passwordEdtTxt.text.toString().isEmpty())
        {
            passwordEdtTxt_Register.error = "missing password"
            passwordEdtTxt_Register.requestFocus()
            return
        }

        else
        {
            auth.signInWithEmailAndPassword(emailEdtTxt_Register.text.toString(), passwordEdtTxt_Register.text.toString()).addOnCompleteListener(this)
            {
                    task ->
                if(task.isSuccessful)
                {
                    val user = auth.currentUser
                    updateUI(user);
                }
                else
                {
                    Toast.makeText(this,"sign in failed. try again later",Toast.LENGTH_SHORT).show()
                }

            }


        }
    }
}