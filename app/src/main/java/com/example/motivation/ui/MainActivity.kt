package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var mSecurityPreferences: SecurityPreferences

    private var mFraseFilter: Int = MotivationConstants.FRASEFILTER.ALL
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        txtName.text = "Aoba, $name"

        //selecao inicial
        imgAll.setColorFilter(resources.getColor(R.color.white))
        handleNewFrase()

        btnNewFrase.setOnClickListener(this)
        imgAll.setOnClickListener(this)
        imgHappy.setOnClickListener(this)
        imgMorning.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(R.id.imgAll, R.id.imgHappy, R.id.imgMorning)
        if (id == R.id.btnNewFrase){
            handleNewFrase()
        }else if (id in listFilter){
            handleNewFilter(id)
        }
    }

    private fun handleNewFilter(id: Int) {

        imgAll.setColorFilter(resources.getColor(R.color.black))
        imgHappy.setColorFilter(resources.getColor(R.color.black))
        imgMorning.setColorFilter(resources.getColor(R.color.black))

        when(id){
            R.id.imgAll -> {
                imgAll.setColorFilter(resources.getColor(R.color.white))
                mFraseFilter = MotivationConstants.FRASEFILTER.ALL
            }
            R.id.imgHappy -> {
                imgHappy.setColorFilter(resources.getColor(R.color.white))
                mFraseFilter = MotivationConstants.FRASEFILTER.HAPPY

            }
            R.id.imgMorning -> {
                imgMorning.setColorFilter(resources.getColor(R.color.white))
                mFraseFilter = MotivationConstants.FRASEFILTER.MORNING

            }
        }
    }

    private fun handleNewFrase() {
        txtMensagem.text = Mock().getFrase(mFraseFilter)
    }
}