package com.elmundo.alveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    var contactos: ArrayList<Contacto>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        contactos = ArrayList()
        contactos?.add(
            Contacto(
                "Liz",
                "Itza Mendez",
                "Halus",
                "Rojo Gomez",
                "98370004765",
                "lizAda1@gmail.com",
                17,
                R.drawable.foto_04,
                54.5F
            )
        )
        val lista = findViewById<ListView>(R.id.lista)
        val Adaptador = AdaptusList(this, contactos!!)
        lista.adapter = Adaptador

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.iNuevo -> {
                val intent = Intent(this, NuevoContact::class.java)
                startActivity(intent)
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

    }
}