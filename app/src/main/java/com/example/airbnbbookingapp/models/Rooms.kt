package com.example.airbnbbookingapp.models

class Rooms {
        var location:String=""
        var bedrooms:String=""
        var roomprice:String=""
        var id:String=""

        constructor(name:String,quantity:String,price:String,id:String){
            this.location=name
            this.bedrooms=quantity
            this.roomprice=price
            this.id=id

        }
        constructor()
    }
