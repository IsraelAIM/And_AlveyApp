package com.elmundo.alveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

class NuevoContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_contact)

        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true);
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_nuevo, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.iCrearNuevo -> {

                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

    }
}