package com.elmundo.alveyapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar

class NuevoContact : AppCompatActivity() {
    var foto: ImageView? = null
    var fotoIndex: Int = 0
    val fotos = arrayOf(
        R.drawable.foto_01,
        R.drawable.foto_02,
        R.drawable.foto_03,
        R.drawable.foto_04,
        R.drawable.foto_05,
        R.drawable.foto_06
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_contact)
        //Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //Carga la opción de retroceso
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true);

        foto = findViewById<ImageView>(R.id.dFoto)
        foto?.setOnClickListener() {
            seleccionarFoto()
        }


    }

    //CREA EL MENU
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_nuevo, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //ANALIZA QUE BOTON SE SELECCIONÓ DEL TOOLBAR
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.iCrearNuevo -> {

                //ZONA DE VARIABLES
                var campos = ArrayList<String>()
                var flag = 0
                val nombre = findViewById<EditText>(R.id.dNombre)
                val apellidos = findViewById<EditText>(R.id.dApellidos)
                val empresa = findViewById<EditText>(R.id.dEmpresa)
                val edad = findViewById<EditText>(R.id.dEdad)
                val peso = findViewById<EditText>(R.id.dPeso)
                val telefono = findViewById<EditText>(R.id.dTelefono)
                val email = findViewById<EditText>(R.id.dEmail)
                val direccion = findViewById<EditText>(R.id.dDireccion)
                //  val foto=findViewById<EditText>(R.id.dNombre)

                //SE AGREGAN AL ARREGLO
                campos.add(nombre.text.toString())
                campos.add(apellidos.text.toString())
                campos.add(empresa.text.toString())
                campos.add(direccion.text.toString())
                campos.add(telefono.text.toString())
                campos.add(email.text.toString())
                campos.add(edad.text.toString())
                campos.add(peso.text.toString())
                //SON MEDIDOS
                for (campo in campos) {
                    if (campo.isNullOrEmpty()) {
                        flag++
                    }
                }
                //SI NO HAY, FUNCIONARÁ
                if (flag > 0) {
                    Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                } else {
                    MainActivity.agregarContacto(
                        Contacto(
                            campos.get(0),
                            campos.get(1),
                            campos.get(2),
                            campos.get(3),
                            campos.get(4),
                            campos.get(5),
                            campos.get(6).toInt(),
                            obtenerFoto(fotoIndex),
                            campos.get(7).toFloat()
                        )
                    )
                    finish()
                    Log.d("No estamos solos", MainActivity.contactos?.count().toString())
                }
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

    }

    fun seleccionarFoto() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Seleccionar imagen para perfil :D")
        val adaptadorDialogo =
            ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item)
        adaptadorDialogo.add("Foto 01")
        adaptadorDialogo.add("Foto 02")
        adaptadorDialogo.add("Foto 03")
        adaptadorDialogo.add("Foto 04")
        adaptadorDialogo.add("Foto 05")
        adaptadorDialogo.add("Foto 06")
        builder.setAdapter(adaptadorDialogo) { dialog, which ->
            fotoIndex = which
            foto?.setImageResource(obtenerFoto(fotoIndex))

        }
        builder.setNegativeButton("Cancelar") { dialog, which ->


            dialog.dismiss()
        }
        builder.show()
    }

    fun obtenerFoto(index: Int): Int {
        return fotos.get(index)
    }

}