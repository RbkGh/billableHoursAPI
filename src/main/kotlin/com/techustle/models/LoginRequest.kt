package com.techustle.models

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 03:34
 *
 */
data class LoginRequest constructor(

        @NotBlank(message = "Email can't be empty")
        @Email(message = "should be an email")
        val username: String,

        @NotBlank(message = "Password can't be empty")
        val password: String
)

