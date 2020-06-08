package com.techustle.db.repository

import com.techustle.db.EmployeeWorkLog
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 *
 * author: acerbk
 * Date: 2020-06-07
 * Time: 02:10
 *
 */
@Repository
interface EmployeeWorkLogRepository : CrudRepository<EmployeeWorkLog, Long> {

    fun findAllByDateOfDayBetween(startDate: Date, endDate: Date):List<EmployeeWorkLog>



}
