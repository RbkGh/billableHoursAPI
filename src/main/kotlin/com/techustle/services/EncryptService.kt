package com.techustle.services

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 03:31
 *
 */
interface EncryptService {
    /**
     * Encrypt password
     *
     * @param unencryptedPassword
     * @return Encrypted password [String]
     */
    fun encrypt(unencryptedPassword: String): String

    /**
     * Check if 2 passwords are same.
     *
     * @param rawPassword
     * @param encryptedPassword
     * @return
     */
    fun isPasswordEqual(rawPassword: String, encryptedPassword: String): Boolean

}
