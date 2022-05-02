package com.example.prviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.prviewer.view.PRListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container_layout)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = PRListFragment()
        transaction.replace(R.id.fragment_container, fragment, fragment.toString())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}