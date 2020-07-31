package com.example.fragmets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity(),FragmentListener {

    private var container:FrameLayout?=null
    private var btnAdd:Button?=null
    private var secondFragment=SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        container=findViewById(R.id.container)
        btnAdd=findViewById(R.id.btnAdd)
    }

    private fun setupListeners(){
        btnAdd?.setOnClickListener {
          setupFragments()
        }
    }
    private fun setupFragments(){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, FirstFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun changeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,secondFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun removeFragment() {
        supportFragmentManager
            .beginTransaction()
            .remove(secondFragment)
            .commit()
    }
}