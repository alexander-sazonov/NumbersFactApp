package com.example.numbersfactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.numbersfactapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.factText.observe(this){
            binding.factTv.text = it
        }
        binding.getFactBtn.setOnClickListener{
            if (binding.numberEt.text.isEmpty()){
                Snackbar.make(it,getString(R.string.snackbar_text), Snackbar.LENGTH_LONG).show()
            }else{
                val number = Integer.parseInt(binding.numberEt.text.toString())
                viewModel.getFact(number)
            }

        }
        binding.getRndBtn.setOnClickListener{
            viewModel.getRandomFact()
        }
    }
}