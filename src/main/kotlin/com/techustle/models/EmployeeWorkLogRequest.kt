package com.techustle.models

import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 20:39
 *
 */
data class EmployeeWorkLogRequest(var userID: Long) {


    var id: Long = 0

    var billableRate: BigDecimal = BigDecimal.ZERO

    var companyID: Long = 0

    var dateOfDay: Date? = null

    var startTime: Timestamp? = null

    private var endTime: Timestamp? = null

    init {
        id = userID
    }
}
