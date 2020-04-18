package com.allisson.appabracao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.allisson.appabracao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.name = "Allisson";
        binding.lastname = "Nunes Dedigo"
        Log.d("Binding", binding.inpName.text.toString())
    }


    fun teste(view: View?){
        Log.d("Binding", binding.inpName.text.toString())
    }
}
