package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash2.*

class SplashActivity2 : AppCompatActivity(), View.OnClickListener {
    
    private lateinit var mSecurityPreferences: SecurityPreferences
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        mSecurityPreferences = SecurityPreferences(this)
        
        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        btnSalvar.setOnClickListener(this)

        verificaNome()
        //val securityPreferences = SecurityPreferences(this)
        //securityPreferences.storeString("", "")
    }

    private fun verificaNome() {
        val nome = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (nome != ""){
            val intent =Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnSalvar){
            handlesave()
        }
    }

    private fun handlesave() {
        val name = edtNome.text.toString()

        if (name != ""){
            mSecurityPreferences.storeString("name", name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(this, "Preencha o Nome", Toast.LENGTH_SHORT).show()
        }
    }
}