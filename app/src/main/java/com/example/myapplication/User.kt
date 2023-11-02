package com.example.myapplication
//https://randomuser.me/api/?results=50&gender=male&inc=email,cell,nat
data class User(var email:String,val cell:String,val gender:String,val nation:String)