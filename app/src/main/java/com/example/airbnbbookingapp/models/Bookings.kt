package com.example.airbnbbookingapp.models

class Bookings {

        var name:String=""
        var email:String=""
        var phone:String=""
        var city:String=""
        var checkindate:String=""
        var checkoutdate:String=""
        var roomnumber:String=""
      

        constructor(name:String,email:String,phone:String,city:String,checkindate:String,checkoutdate:String,roomnumber:String){

            this.name=name
            this.email=email
            this.phone=phone
            this.city=city
            this.checkindate=checkindate
            this.checkoutdate=checkoutdate
            this.roomnumber=roomnumber


        }
        constructor()
    }
