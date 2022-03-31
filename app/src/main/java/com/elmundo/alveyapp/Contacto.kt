package com.elmundo.alveyapp

class Contacto(nombre:String,apellidos:String,empresa:String,direccion:String,telefono:String,email:String,edad:Int,foto:Int,peso:Float) {
    var nombre:String=""
    var apellidos:String=""
    var empresa:String=""
    var direccion:String=""
    var telefono:String=""
    var email:String=""
    var edad:Int=0
    var foto:Int=0
    var peso:Float=0.0F

    init {
        this.nombre=nombre
        this.apellidos=apellidos
        this.empresa=empresa
        this.direccion=direccion
        this.telefono=telefono
        this.email=email
        this.edad=edad
        this.foto=foto
        this.peso=peso
    }


}