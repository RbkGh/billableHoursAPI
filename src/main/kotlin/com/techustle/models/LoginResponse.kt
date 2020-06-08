package com.techustle.models

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 03:36
 *
 */
data class LoginResponse( private val tokenKey: String) {

    var token:String = ""
    var id: Long = 0
    var firstName: String? = null
    var roleName: String? = null
    var surName: String? = null

    init {
        token = tokenKey
    }
    constructor() : this("")
}
