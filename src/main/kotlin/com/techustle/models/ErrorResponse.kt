package com.techustle.models

import com.techustle.exceptions.ErrorResource

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 04:36
 *
 */
class ErrorResponse {
    private var message: String? = null
    private lateinit var errorResource: ErrorResource


    constructor(message: String) {
        this.message = message
    }


    constructor(message: String, errorResource: ErrorResource) {
        this.message = message
        this.errorResource = errorResource
    }
}
