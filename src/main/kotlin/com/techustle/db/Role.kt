package com.techustle.db

import javax.persistence.*

/**
 *
 * author: acerbk
 * Date: 2020-06-03
 * Time: 04:28
 *
 */
@Entity
@Table(name = "role")
class Role(

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(length = 25, unique = true)
        @Enumerated(EnumType.STRING)
        var roleName: RoleName,

        @JoinTable(name = "roles_privileges", joinColumns = arrayOf(JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)), inverseJoinColumns = arrayOf(JoinColumn(name = "privilege_id", referencedColumnName = "id", nullable = false)))
        @ManyToMany
        val privilegeList: List<Privilege>
){

}
