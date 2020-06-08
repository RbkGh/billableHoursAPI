package com.techustle.services

import com.techustle.db.Company
import com.techustle.db.EmployeeWorkLog
import com.techustle.db.repository.CompanyRepository
import com.techustle.db.repository.EmployeeWorkLogRepository
import com.techustle.db.repository.UserRepository
import com.techustle.models.EmployeeWorkLogRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.Period
import java.time.ZoneId


/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 21:53
 *
 */
@Service
class LawyerService {

    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var companyRepository: CompanyRepository
    @Autowired
    private lateinit var employeeWorkLogRepository: EmployeeWorkLogRepository


    fun createSingleLawyerBill(employeeWorkLogRequest: EmployeeWorkLogRequest) {

        val company: Company = companyRepository
                .findById(employeeWorkLogRequest.companyID).get()

        var numberOfHoursForBill: Int = findDifferenceInHours(employeeWorkLogRequest.startTime, employeeWorkLogRequest.endTime)

        var durationCost: BigDecimal = employeeWorkLogRequest.billableRate.multiply(BigDecimal.valueOf(numberOfHoursForBill.toLong()))

        val userInDB = userRepository.findById(employeeWorkLogRequest.userID).get()

        val employeeWorkLog: EmployeeWorkLog = EmployeeWorkLog.Builder()
                .billableRate(employeeWorkLogRequest.billableRate)
                .company(company)
                .dateOfDay(employeeWorkLogRequest.dateOfDay)
                .startTime(employeeWorkLogRequest.startTime)
                .endTime(employeeWorkLogRequest.endTime)
                .noOfHours(numberOfHoursForBill)
                .durationCost(durationCost)
                .user(userInDB)
                .build()

        employeeWorkLogRepository.save(employeeWorkLog)
    }

    fun isUserPresent(userID: Long): Boolean {
        return (userRepository.existsById(userID))
    }

    /**
     * find difference in hours between two timestamps
     */
    fun findDifferenceInHours(startTime: Timestamp, endTime: Timestamp): Int {
        val startLocalDate = startTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val endLocaldDate = endTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val period = Period.between(startLocalDate, endLocaldDate)
        return period.days / 3600
    }
}
