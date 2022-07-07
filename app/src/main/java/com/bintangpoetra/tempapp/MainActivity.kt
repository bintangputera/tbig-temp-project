package com.bintangpoetra.tempapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bintangpoetra.tempapp.data.area.dummy.AreaDummyData.getAreaDummyList
import com.bintangpoetra.tempapp.presentation.adapter.AreaAdapter
import com.bintangpoetra.tempapp.presentation.area.add.AddNewAreaActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rvArea: RecyclerView
    private lateinit var btnAddNewArea: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        initAction()

    }

    private fun initUI() {
        rvArea = findViewById(R.id.rv_area)
        btnAddNewArea = findViewById(R.id.btn_add_assignment)

        val adapter = AreaAdapter(getAreaDummyList())
        rvArea.adapter = adapter
        rvArea.layoutManager = LinearLayoutManager(this)
    }

    private fun initAction() {
        btnAddNewArea.setOnClickListener {
            AddNewAreaActivity.start(this)
        }
    }

}