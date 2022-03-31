package com.elmundo.alveyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptusList(var context: Context, items: ArrayList<Contacto>) : BaseAdapter() {
    var items: ArrayList<Contacto>? = null

    init {
        this.items = items
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(p0: Int): Any {
        return items?.get(p0)!!
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var holder: ViewHolder? = null //ViewHolder como variable
        var vista: View? = p1
        //Aqui analiza el template como base
        if (vista == null) {
            vista = LayoutInflater.from(context).inflate(R.layout.template_contacto, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        } else { //Reusando una
            holder = vista.tag as? ViewHolder
        }
        val item = getItem(p0) as Contacto
        //Analiza la clase contacto. Lo existente en ella para representarla como vista. SE ASIGNAN LOS VALORES A VISUALES
        holder?.nombre?.text = item.nombre + " "+item.apellidos
        holder?.empresa?.text = item.empresa
        holder?.imagen?.setImageResource(item.foto)
        return vista!!

    }

    private class ViewHolder(vista: View) {
        var nombre: TextView? = null
        var empresa: TextView? = null
        var imagen: ImageView? = null

        init {
            nombre = vista.findViewById(R.id.tvNombre)
            empresa = vista.findViewById(R.id.tvEmpresa)
            imagen = vista.findViewById(R.id.ivFoto)
        }


    }
}