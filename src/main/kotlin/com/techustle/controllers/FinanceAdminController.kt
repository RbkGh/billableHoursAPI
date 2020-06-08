package com.techustle.controllers

import com.techustle.exceptions.EntityNotFoundCustomException
import com.techustle.exceptions.InvalidRequestException
import com.techustle.models.EmployeeWorkLogRequest
import com.techustle.services.FinanceService
import com.techustle.services.LawyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.annotation.security.RolesAllowed

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 20:33
 *
 */
@RestController
@RequestMapping("/api/v1/finance")
class FinanceAdminController {

    @Autowired
    private lateinit var lawyerService: LawyerService
    @Autowired
    private lateinit var financeService: FinanceService



    @GetMapping("/company/{companyID}/invoice")
    fun getCompanyInvoiceSheetForTimeFrame(@PathVariable companyID: Long,
                               @RequestParam(value = "startDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") startDate: Date,
                               @RequestParam(value = "endDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") endDate: Date): ResponseEntity<*> {

        if (!lawyerService.isUserPresent(companyID))
            throw EntityNotFoundCustomException("User does not exist")

        var lawyerLOGS = lawyerService.getLawyerWorkLogsForTimeRange(startDate, endDate, companyID)

        return ResponseEntity.status(HttpStatus.OK).body<Any>(lawyerLOGS)
    }

    @RolesAllowed("ROLE_FINANCE_ADMIN")
    @GetMapping("/timesheet")
    fun getAllLawyerTimeSheets(): ResponseEntity<*> {
        return ResponseEntity.ok().body<Any>(lawyerService.getAllLawyerWorkLogs())
    }

}
