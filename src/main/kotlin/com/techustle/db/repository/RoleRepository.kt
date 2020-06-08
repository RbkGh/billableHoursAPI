package com.techustle.db.repository

import com.techustle.db.Role
import com.techustle.db.RoleName
import org.springframework.data.repository.CrudRepository

/**
 *
 * author: acerbk
 * Date: 2020-06-07
 * Time: 17:35
 *
 */
interface RoleRepository : CrudRepository<Role, Long> {
    fun findByRoleName(roleName: RoleName):Role
}
