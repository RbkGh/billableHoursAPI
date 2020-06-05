package com.techustle.security

import com.fasterxml.jackson.annotation.JsonIgnore
import com.techustle.db.Role
import com.techustle.db.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

/**
 *
 * author: acerbk
 * Date: 2020-06-04
 * Time: 02:24
 *
 */
class UserPrincipal(private var id: Long,
                    private var name: String,
                    private var userName: String,
                    @JsonIgnore private var email: String,
                    private var passwordString: String,
                    private var authorities: List<GrantedAuthority>,
                    private var user: User) : UserDetails {


    companion object {
        @JvmStatic
        fun createUserPrincipalFromUserEntity(user: User) :UserPrincipal{
            var authoritiesCustom: List<GrantedAuthority> = user.roleList.stream().map { role: Role? ->
                SimpleGrantedAuthority(role?.roleName.toString())
            }.collect(Collectors.toList())

            return UserPrincipal(user.id,
                    user.firstName+" "+user.surName,
                    user.email,
                    user.email,
                    String(user.password),
                    authoritiesCustom,
                    user)
        }
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities.toMutableList()
    }

    override fun isEnabled(): Boolean {
        return user.accountActive
    }

    override fun getUsername(): String {
        return userName
    }

    override fun isCredentialsNonExpired(): Boolean {
        return user.accountActive
    }

    override fun getPassword(): String {
        return passwordString
    }

    override fun isAccountNonExpired(): Boolean {
        return user.accountActive
    }

    override fun isAccountNonLocked(): Boolean {
        return user.accountActive
    }

    fun getEmail(): String {
        return email
    }

}
