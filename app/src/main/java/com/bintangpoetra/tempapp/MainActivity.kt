package com.bintangpoetra.tempapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bintangpoetra.tempapp.data.area.dummy.AreaDummyData.getAreaDummyList
import com.bintangpoetra.tempapp.presentation.adapter.AreaAdapter
import com.bintangpoetra.tempapp.presentation.area.add.AddNewAreaActivity
import com.bintangpoetra.tempapp.presentation.reusable.CustomDialogFragment
import com.bintangpoetra.tempapp.utils.ConstVal.DIALOG_TAG

class MainActivity : AppCompatActivity() {

    private lateinit var rvArea: RecyclerView
    private lateinit var btnAddNewArea: Button
    private lateinit var btnFinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        initAction()
    }

    private fun initUI() {
        rvArea = findViewById(R.id.rv_area)
        btnAddNewArea = findViewById(R.id.btn_add_assignment)
        btnFinish = findViewById(R.id.btn_finish_task)

        val adapter = AreaAdapter(getAreaDummyList(), onClick = {
            CustomDialogFragment.newInstance(
                title = getString(R.string.label_delete_area),
                description = "Are you sure want to delete ${it.areaName} area ?",
                imageResourceId = R.drawable.ic_delete,
                negativeButton = getString(R.string.action_delete),
                positiveButton = getString(R.string.action_cancel)
            ).show(supportFragmentManager, DIALOG_TAG)
        })
        rvArea.adapter = adapter
        rvArea.layoutManager = LinearLayoutManager(this)
    }

    private fun initAction() {
        btnAddNewArea.setOnClickListener {
            AddNewAreaActivity.start(this)
        }
        btnFinish.setOnClickListener {
            CustomDialogFragment.newInstance(
                title = getString(R.string.label_finish_task),
                description = "Are you sure want to finish task ?",
                imageResourceId = R.drawable.ic_success,
                negativeButton = getString(R.string.action_cancel),
                positiveButton = getString(R.string.action_finish)
            ).show(supportFragmentManager, DIALOG_TAG)
        }
    }
}