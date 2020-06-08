package com.techustle.db

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.*

/**
 *
 * author: acerbk
 * Date: 2020-06-03
 * Time: 03:39
 *
 */
@Entity
@Table(name = "user")
class User(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var email: String,
        var dateCreated: Date,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        var password: ByteArray,
        var firstName: String,
        var surName: String,
        var dateOfBirth: Date,
        //var sex: Sex,
        var accountActive: Boolean = true,
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "users_roles", joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "role_id", referencedColumnName = "id")))
        var roleList: List<Role>
)
