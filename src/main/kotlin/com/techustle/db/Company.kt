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
        private var id: Long,

        private var companyName: String,


        @JoinColumn(name = "employee_work_log_id", referencedColumnName = "id")
        @ManyToOne(optional = false)
        private var employeeWorkLog:EmployeeWorkLog
)
