package com.techustle.exceptions

import org.springframework.validation.Errors

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 04:10
 *
 */
class InvalidRequestException(val errors: Errors) : RuntimeException("")
