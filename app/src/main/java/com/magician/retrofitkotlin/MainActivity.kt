package com.magician.retrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.magician.retrofitkotlin.adapter.MyAdapter
import com.magician.retrofitkotlin.repo.Repo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerview()
        val repo = Repo()
        val viewModelFactory = MainViewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomPost(5, "id", "desc")
        viewModel.myCustomResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { myAdapter.setData(it) }
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })


        /*  val options: HashMap<String, String> = HashMap()
          options["_sort"] = "id"
          options["_order"] = "desc"

          search_button.setOnClickListener {
              val myNumber = number_edit_text.text.toString()
              viewModel.getCustomPost2(Integer.parseInt(myNumber), options)

              viewModel.myCustomResponse2.observe(this, Observer { response ->
                  if (response.isSuccessful) {
                      text_view.text = response.body()?.toString()
                      response.body()?.forEach {
                          Log.d("Response", it.userId.toString())
                          Log.d("Response", it.id.toString())
                          Log.d("Response", it.title)
                          Log.d("Response", it.body)
                      }
                  } else {
                      text_view.text = response.code().toString()
                  }
              })
          }*/


    }

    private fun setupRecyclerview() {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}
