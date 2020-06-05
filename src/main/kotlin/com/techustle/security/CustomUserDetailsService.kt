package com.techustle.security

import com.techustle.db.User
import com.techustle.db.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 *
 * author: acerbk
 * Date: 2020-06-05
 * Time: 15:38
 *
 */
@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        return createUserDetailsFromUserEntity(userRepository.findByEmail(username!!)
                .orElseThrow { UsernameNotFoundException("userid not found") })
    }

    private fun createUserDetailsFromUserEntity(user: User): UserDetails {
        return UserPrincipal.createUserPrincipalFromUserEntity(user)
    }
}
