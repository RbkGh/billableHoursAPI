package com.techustle.db.repository

import com.techustle.db.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 *
 * author: acerbk
 * Date: 2020-06-05
 * Time: 15:43
 *
 */
@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByEmail(email: String): Optional<User>
}
