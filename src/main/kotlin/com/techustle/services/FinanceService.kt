package com.techustle.services

import com.techustle.db.EmployeeWorkLog
import com.techustle.db.repository.CompanyRepository
import com.techustle.db.repository.EmployeeWorkLogRepository
import com.techustle.db.repository.UserRepository
import com.techustle.models.CompanyInvoiceResponse
import com.techustle.models.EmployeeRecordForCompanyInvoice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 21:53
 *
 */
@Service
class FinanceService {

    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var companyRepository: CompanyRepository
    @Autowired
    private lateinit var employeeWorkLogRepository: EmployeeWorkLogRepository
    @Autowired
    private lateinit var financeService: FinanceService

    fun getCompanyInvoiceSheetForTimeFrame(companyID: Long, startDate: Date, endDate: Date): CompanyInvoiceResponse {

        val company = companyRepository.findById(companyID)

        var employeeBillRecordsList = getEmployeeBillRecordsList(companyID, startDate, endDate)

        var totalCompanyInvoiceBill = getTotalCostForCompany(employeeBillRecordsList).toBigDecimal() //better to convert from s

        return CompanyInvoiceResponse(
                company.get(),
                employeeBillRecordsList,
                totalCompanyBillCost = totalCompanyInvoiceBill
        )

    }

    fun isCompanyPresent(companyID: Long): Boolean {
        return companyRepository.existsById(companyID)
    }

    fun getTotalCostForCompany(listOfRecords: List<EmployeeRecordForCompanyInvoice>): Double {
        return listOfRecords.sumByDouble { record ->
            record.totalCostOfWork.toDouble()
        }
    }

    fun getEmployeeBillRecordsList(companyID: Long, startDate: Date, endDate: Date): List<EmployeeRecordForCompanyInvoice> {
        var employeeWorkLogList: List<EmployeeWorkLog> = employeeWorkLogRepository
                .findAllByCompany_IdAndDateOfDayBetween(companyID, startDate, endDate)

        var employeeRecordList: List<EmployeeRecordForCompanyInvoice> = employeeWorkLogList
                .map { t -> transformToEmployeeRecordBill(t) }
                .toList()
        return employeeRecordList
    }

    fun transformToEmployeeRecordBill(employeeWorkLog: EmployeeWorkLog): EmployeeRecordForCompanyInvoice {

        return EmployeeRecordForCompanyInvoice(employeeID = employeeWorkLog.id!!,
                totalNoOfHours = employeeWorkLog.noOfHours!!,
                unitPrice = employeeWorkLog.billableRate!!,
                totalCostOfWork = employeeWorkLog.durationCost!!)
    }


}
