package com.example.airbnbbookingapp.models



class Upload{
    var locaion:String=""
    var bedrooms:String=""
    var roomprice:String=""
    var imageUrl:String=""
    var id:String=""

    constructor(location:String,bedrooms:String,roomprice:String,imageUrl:String,id:String){

        this.locaion=location
        this.bedrooms=bedrooms
        this.roomprice=roomprice
        this.imageUrl=imageUrl
        this.id=id

    }
    constructor()
}