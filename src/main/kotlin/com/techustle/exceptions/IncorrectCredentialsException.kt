package com.techustle.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 18:54
 * THROW WHEN CREDENTIALS ARE INCORRECT eg wrong password or wrong username
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
class IncorrectCredentialsException (reason: String?) : RuntimeException(String.format(reason!!)) {
    private val reason: String? = null
}
