package com.techustle.db


import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 19:48
 *
 */
@Entity
@Table(name = "employee_work_log")
class EmployeeWorkLog(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private var id: Long,

        private var billableRate: Int,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "employeeWorkLog")
        private var companyList: List<Company>,

        @Column(name = "date_of_day", nullable = false)
        private var dateOfDay: Date,

        private var startTime: Timestamp,

        private var endTime: Timestamp,

        private var noOfHours: Int,

        @Column(nullable = true)
        private var durationCost: BigDecimal
)
