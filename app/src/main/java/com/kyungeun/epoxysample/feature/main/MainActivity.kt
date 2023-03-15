package com.kyungeun.epoxysample.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyungeun.epoxysample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val mainController = MainController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupEpoxyRecyclerView()
        setupObservers()
    }

    private fun setupEpoxyRecyclerView() {
        binding.rvHome.layoutManager = LinearLayoutManager(this)

        binding.rvHome.setController(mainController)
    }

    private fun setupObservers() {
        viewModel.userProjects.observe(this) {
            Log.d("MainActivity", "setupObservers: ${it.data}")
//            mainController.setData(it.data!!)
        }
    }
}