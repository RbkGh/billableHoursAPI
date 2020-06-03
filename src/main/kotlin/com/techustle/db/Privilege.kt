package com.techustle.db

import javax.persistence.*

/**
 *
 * author: acerbk
 * Date: 2020-06-03
 * Time: 12:56
 *
 */
@Entity
@Table(name = "privilege")
class Privilege (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long,
    @Column(length = 30)
    private var name: String,
    @ManyToMany(mappedBy = "privilegeList")
    private var roleList: List<Role> = mutableListOf()
){
    constructor(myId: Long): this(myId,"", emptyList()){}
}
