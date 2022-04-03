package com.elmundo.alveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class Detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true);

        val index= intent.getStringExtra("ID")?.toInt()
        Log.d("INDEX",index.toString())
        val contacto=MainActivity.contactos?.get(index!!)

        var tvNombre=findViewById<TextView>(R.id.dNombre)
        var tvEmpresa=findViewById<TextView>(R.id.dEmpresa)
        var tvEdad=findViewById<TextView>(R.id.dEdad)
        var tvPeso=findViewById<TextView>(R.id.dPeso)
        var tvTelefono=findViewById<TextView>(R.id.dTelefono)
        var tvEmail=findViewById<TextView>(R.id.dEmail)

        tvNombre.text=contacto?.nombre+" "+contacto?.apellidos
        tvEmpresa.text=contacto?.empresa
        tvEdad.text=contacto?.edad.toString()+" años"
        tvPeso.text=contacto?.peso.toString()+" kg"
        tvTelefono.text=contacto?.telefono
        tvEmail.text=contacto?.email

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
           android.R.id.home->{
               finish()
               return true
           }
           R.id.iEditar->{
               return true
           }
           R.id.iEliminar->{
               return true
           }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }



}