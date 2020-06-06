package com.techustle.controllers

import com.techustle.models.EmployeeWorkLogRequest
import org.springframework.web.bind.annotation.*

/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 20:33
 *
 */
@RestController
@RequestMapping("/api/v1/lawyer")
class LawyerController {

    @PostMapping("/{userID}/bill")
    fun createSingleBillableTimeRecord(@PathVariable userID: Long, @RequestBody employeeWorkLogRequest: EmployeeWorkLogRequest) {

    }

}
