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
data class EmployeeWorkLog(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,

        @JoinColumn(name = "user_id", referencedColumnName = "id")
        @ManyToOne
        val user: User?,

        val billableRate: BigDecimal?,

        @JoinColumn(name = "company_id", referencedColumnName = "id")
        @ManyToOne
        val company: Company?,

        @Column(name = "date_of_day", nullable = false)
        @Temporal(TemporalType.DATE)
        val dateOfDay: Date?,

        val startTime: Timestamp?,

        val endTime: Timestamp?,

        val noOfHours: Int?,

        @Column(nullable = true)
        val durationCost: BigDecimal?
) {

    data class Builder(
            var id: Long? = null,
            var user: User? = null,
            var billableRate: BigDecimal? = null,
            var company: Company? = null,
            var dateOfDay: Date? = null,
            var startTime: Timestamp? = null,
            var endTime: Timestamp? = null,
            var noOfHours: Int? = null,
            var durationCost: BigDecimal? = null) {

        fun id(id: Long) = apply { this.id = id }
        fun user(user: User) = apply { this.user = user }
        fun billableRate(billableRate: BigDecimal) = apply { this.billableRate = billableRate }
        fun company(company: Company) = apply { this.company = company }
        fun dateOfDay(dateOfDay: Date) = apply { this.dateOfDay = dateOfDay }
        fun startTime(startTime: Timestamp) = apply { this.startTime = startTime }
        fun endTime(endTime: Timestamp) = apply { this.endTime = endTime }
        fun noOfHours(noOfHours: Int) = apply { this.noOfHours = noOfHours }
        fun durationCost(durationCost: BigDecimal) = apply { this.durationCost = durationCost }


        fun build() = EmployeeWorkLog(id, user, billableRate, company, dateOfDay, startTime, endTime, noOfHours, durationCost)
    }

}
