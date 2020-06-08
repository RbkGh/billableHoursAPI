package com.techustle.db

import javax.persistence.*

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 19:40
 *
 */
@Entity
@Table(name = "company")
class Company(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        var companyName: String,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "company")
        private var employeeWorkLogList: List<EmployeeWorkLog>
)
