package com.techustle.controllers

import com.techustle.exceptions.EntityNotFoundCustomException
import com.techustle.exceptions.InvalidRequestException
import com.techustle.models.EmployeeWorkLogRequest
import com.techustle.services.LawyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
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

    @Autowired
    private lateinit var lawyerService: LawyerService

    @PostMapping("/{userID}/bill")
    fun createSingleBillableTimeRecord(@PathVariable userID: Long,
                                       @RequestBody employeeWorkLogRequest: EmployeeWorkLogRequest,
                                       bindingResult: BindingResult): ResponseEntity<*> {
        if (bindingResult.hasErrors())
            throw InvalidRequestException(bindingResult)

        employeeWorkLogRequest.userID = userID

        if (!lawyerService.isUserPresent(userID))
            throw EntityNotFoundCustomException("User does not exist")

        lawyerService.createSingleLawyerBill(employeeWorkLogRequest)

        return ResponseEntity.status(HttpStatus.CREATED).body<Any>(null)

    }

}
