package com.techustle.services

import com.techustle.db.Company
import com.techustle.db.EmployeeWorkLog
import com.techustle.db.repository.CompanyRepository
import com.techustle.db.repository.EmployeeWorkLogRepository
import com.techustle.db.repository.UserRepository
import com.techustle.models.EmployeeWorkLogRequest
import org.joda.time.DateTimeZone
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.sql.Timestamp
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



}
