package com.hubose.eniroapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hubose.eniroapplication.common.ImageLoader
import com.hubose.eniroapplication.list.ListAdapter
import com.hubose.eniroapplication.list.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModel()
    private val imageLoader: ImageLoader by inject()
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.error.observe(this, Observer { showDialog(it.localizedMessage) })
        listAdapter = ListAdapter(this, viewModel.getData(), imageLoader){
            showDialog(it)
        }
        rv_main.adapter = listAdapter
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(
            rv_main.context,
            layoutManager.orientation
        )
        rv_main.addItemDecoration(dividerItemDecoration)
        rv_main.layoutManager = layoutManager
    }

    private fun showDialog(msg: String){
        AlertDialog.Builder(this)
            .setMessage(msg)
            .setPositiveButton(android.R.string.ok) {
                dialogInterface, _ ->  dialogInterface.dismiss()
        }.show()
    }
}
