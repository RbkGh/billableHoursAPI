package com.techustle.services

import com.techustle.db.repository.UserRepository
import com.techustle.exceptions.EntityNotFoundCustomException
import com.techustle.exceptions.IncorrectCredentialsException
import com.techustle.models.LoginRequest
import com.techustle.models.LoginResponse
import com.techustle.security.JWTProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 18:21
 *
 */
@Service
class AuthenticationService {

    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var jwtProvider: JWTProvider
    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    @Autowired
    private lateinit var encryptService: DefaultEncryptionService

    fun authenticate(loginRequest: LoginRequest): LoginResponse? {
        val userNameFromRequest = loginRequest.username
        val passwordFromRequest = loginRequest.password

        val optionalUser = userRepository.findByEmail(
                userNameFromRequest)
                .orElseThrow { IncorrectCredentialsException("wrong username and password combination") }

        val encodedPasswordFromDb = String(optionalUser.password)

        if (encryptService.isPasswordEqual(passwordFromRequest, encodedPasswordFromDb)) {
            val authentMan = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(
                    userNameFromRequest,
                    passwordFromRequest
            ))

            val token = jwtProvider.generateToken(authentMan)

            val loginResponse = LoginResponse(token)
            loginResponse.id = optionalUser.id
            loginResponse.firstName = optionalUser.firstName
            loginResponse.surName = optionalUser.surName
            loginResponse.roleName = optionalUser.roleList.get(0).roleName.toString()

            return loginResponse
        }
        return null
    }
}
