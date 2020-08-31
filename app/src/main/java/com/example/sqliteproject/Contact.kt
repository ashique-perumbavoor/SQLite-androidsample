package com.example.sqliteproject

import java.io.Serializable

class Contact : Serializable {
    var id = 0
    var name: String? = null
    var phone: String? = null
    var address: String? = null
    var email: String? = null
    var description: String? = null

}