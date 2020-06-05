package com.techustle.db.repository

import com.techustle.db.User
import org.springframework.data.repository.CrudRepository
import java.util.*

/**
 *
 * author: acerbk
 * Date: 2020-06-05
 * Time: 15:43
 *
 */
interface UserRepository : CrudRepository<User, Long> {
    fun findByEmail(email: String): Optional<User>
}
