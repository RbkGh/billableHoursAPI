package com.techustle.services

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 16:44
 *
 */
@Service
class DefaultEncryptionService : EncryptService {
    override fun encrypt(unencryptedPassword: String): String {
        return BCryptPasswordEncoder(12).encode(unencryptedPassword)
    }

    override fun isPasswordEqual(rawPassword: String, encryptedPassword: String): Boolean {
        return BCryptPasswordEncoder(12).matches(rawPassword, encryptedPassword)
    }

}
