package com.techustle.security

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *
 * author: acerbk
 * Date: 2020-06-05
 * Time: 15:57
 *
 */
@Component
class JWTSecurityAuthenticationEntryPoint : AuthenticationEntryPoint {

    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        response!!.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException!!.message)
    }
}
