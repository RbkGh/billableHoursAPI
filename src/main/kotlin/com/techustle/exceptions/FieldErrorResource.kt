package com.techustle.exceptions

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 04:33
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class FieldErrorResource(private val resource: String, private val field: String, private val code: String, private val message: String)
