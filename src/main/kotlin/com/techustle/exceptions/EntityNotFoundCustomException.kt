package com.techustle.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 18:15
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class EntityNotFoundCustomException(reason: String?) : RuntimeException(String.format(reason!!)) {
    private val reason: String? = null
}
