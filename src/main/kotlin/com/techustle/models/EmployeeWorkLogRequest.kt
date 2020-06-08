package com.techustle.models

import java.math.BigDecimal
import java.sql.Timestamp
import java.time.Instant
import java.util.*

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 20:39
 *
 */
data class EmployeeWorkLogRequest(var userID: Long) {


    //var id: Long = 0

    var billableRate: BigDecimal = BigDecimal.ZERO

    var companyID: Long = 0

    var dateOfDay: Date = Date()

    var startTime: Timestamp = Timestamp.from(Instant.now())

    var endTime: Timestamp = Timestamp.from(Instant.now())
}
