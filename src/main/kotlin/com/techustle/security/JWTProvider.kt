package com.techustle.security

import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

/**
 *
 * author: acerbk
 * Date: 2020-06-05
 * Time: 16:11
 *
 */
@Component
class JWTProvider {

    @Value("\${app.jwtSecret}")
    private val jwtSecret: String? = null

    @Value("\${app.jwtExpirationInMs}")
    private val jwtExpirationInMs: Int = 0

    fun generateToken(authentication: Authentication): String {

        val userDetails = authentication.principal as UserPrincipal

        val now = Date()
        val expiryDate = Date(now.time + jwtExpirationInMs)

        return Jwts.builder()
                .setSubject(userDetails.getEmail())
                .setIssuedAt(Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact()
    }

    fun getUserIdFromJWT(token: String): String {
        val claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .body

        return claims.subject
    }

    fun validateToken(authToken: String): Boolean {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
            return true
        } catch (ex: SignatureException) {
            print("Invalid JWT signature")
        } catch (ex: MalformedJwtException) {
            print("Invalid JWT token")
        } catch (ex: ExpiredJwtException) {
            print("Expired JWT token")
        } catch (ex: UnsupportedJwtException) {
            print("Unsupported JWT token")
        } catch (ex: IllegalArgumentException) {
            print("JWT claims string is empty.")
        }
        return false
    }
}
