package com.example.ecommerce

class EProduct
{
    var id: Int
    var name: String
    var price: Int
    var brand: String
    var picture: String

    constructor(id:Int,name:String,price:Int,brand:String,picture:String)
    {
        this.id=id
        this.name=name
        this.price=price
        this.brand=brand
        this.picture=picture
    }
}