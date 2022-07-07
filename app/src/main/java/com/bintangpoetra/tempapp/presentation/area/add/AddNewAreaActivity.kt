package com.bintangpoetra.tempapp.presentation.area.add

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.bintangpoetra.tempapp.R

class AddNewAreaActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, AddNewAreaActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_area)

        initUI()
        initAction()
    }

    private fun initUI(){
        toolbar = findViewById(R.id.toolbar)
    }

    private fun initAction() {
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}