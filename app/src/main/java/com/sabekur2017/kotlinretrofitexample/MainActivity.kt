package com.sabekur2017.kotlinretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sabekur2017.kotlinretrofitexample.api.ApiHelper
import com.sabekur2017.kotlinretrofitexample.api.ApiServiceImpl
import com.sabekur2017.kotlinretrofitexample.model.User
import com.sabekur2017.kotlinretrofitexample.ui.base.ViewModelFactory
import com.sabekur2017.kotlinretrofitexample.ui.main.adapter.MainAdapter
import com.sabekur2017.kotlinretrofitexample.ui.main.viewmodel.MainViewModel
import com.sabekur2017.kotlinretrofitexample.utils.Status
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUi()
        setupViewModel()
        setupObserver()
    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            when(it.status){
                Status.SUCCESS->{
                    progressBar.visibility= View.GONE
                    it.data?.let { users->renderList(users) }
                    recyclerView.visibility=View.VISIBLE
                }
                Status.LOADING->{
                    progressBar.visibility=View.VISIBLE
                    recyclerView.visibility=View.GONE
                }
                Status.ERROR->{
                    progressBar.visibility=View.GONE
                    Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupViewModel() {
  mainViewModel= ViewModelProviders.of(
          this,
ViewModelFactory(ApiHelper(ApiServiceImpl()))
  ).get(MainViewModel::class.java)
    }
    private fun renderList(users:List<User>){
        mainAdapter.addData(users)
        mainAdapter.notifyDataSetChanged()
    }

    private fun setupUi() {
        recyclerView.layoutManager=LinearLayoutManager(this)
        mainAdapter= MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        recyclerView.context,
                        (recyclerView.layoutManager as LinearLayoutManager).orientation
                )

        )
        recyclerView.adapter=mainAdapter

    }
}