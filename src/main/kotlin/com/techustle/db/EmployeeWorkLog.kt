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

        @JoinColumn(name = "user_id", referencedColumnName = "id")
        @ManyToOne
        private var user : User,

        private var billableRate: BigDecimal,

        @JoinColumn(name = "company_id", referencedColumnName = "id")
        @ManyToOne
        private var company: Company,

        @Column(name = "date_of_day", nullable = false)
        private var dateOfDay: Date,

        private var startTime: Timestamp,

        private var endTime: Timestamp,

        private var noOfHours: Int,

        @Column(nullable = true)
        private var durationCost: BigDecimal
)
