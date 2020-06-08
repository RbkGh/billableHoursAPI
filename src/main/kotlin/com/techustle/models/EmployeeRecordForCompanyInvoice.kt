package com.techustle.models

import java.math.BigDecimal

/**
 *
 * author: acerbk
 * Date: 2020-06-08
 * Time: 19:21
 *
 */
class EmployeeRecordForCompanyInvoice(
        var employeeID: Long,
        var totalNoOfHours: Int,
        var unitPrice: BigDecimal,
        var totalCostOfWork: BigDecimal
) {

}
