package com.techustle.exceptions

import org.springframework.http.HttpStatus
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.ResponseStatus

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 04:10
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidRequestException(val errors: Errors) : RuntimeException("")
