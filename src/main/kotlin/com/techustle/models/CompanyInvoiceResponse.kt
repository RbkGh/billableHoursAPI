package com.techustle.models

import com.techustle.db.Company
import java.math.BigInteger

/**
 *
 * author: acerbk
 * Date: 2020-06-08
 * Time: 19:19
 *
 */
data class CompanyInvoiceResponse(
        var company: Company,
        var employeeBillRecords: List<EmployeeRecordForCompanyInvoice>,
        /**
         * total amount that the company owes the law firm after all employee bills have been collated for the week
         */
        var totalCompanyBillCost:BigInteger
) {
}
