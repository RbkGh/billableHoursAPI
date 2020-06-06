package com.techustle.controllers

import com.techustle.exceptions.InvalidRequestException
import com.techustle.models.ErrorResponse
import com.techustle.models.LoginRequest
import com.techustle.services.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 02:43
 *
 */
@RestController
@RequestMapping("/api/v1/auth")
class AuthController {

    @Autowired
    private lateinit var authenticationService: AuthenticationService


    @Throws(EntityNotFoundException::class)
    @RequestMapping(value = ["/signin"], method = [RequestMethod.POST], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun authenticate(
            @Valid @RequestBody loginRequest: LoginRequest,
            bindingResult: BindingResult): ResponseEntity<*> {
        if (bindingResult.hasErrors())
            throw InvalidRequestException(bindingResult)

        val authenticationResult = authenticationService.authenticate(loginRequest)
        if (authenticationResult != null)
            return ResponseEntity.status(HttpStatus.OK).body(authenticationResult)

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body<Any>(ErrorResponse("Your Password is incorrect"))
    }

}


