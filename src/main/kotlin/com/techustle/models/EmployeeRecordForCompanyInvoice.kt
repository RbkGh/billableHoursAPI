package com.techustle.models

import java.math.BigInteger

/**
 *
 * author: acerbk
 * Date: 2020-06-08
 * Time: 19:21
 *
 */
class EmployeeRecordForCompanyInvoice(
        var employeeID: Long,
        var totalNoOfHours:Int,
        var unitPrice: BigInteger,
        var totalCostOfWork: BigInteger
) {

}
