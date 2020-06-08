package com.techustle.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.techustle.db.Company
import com.techustle.db.Role
import com.techustle.db.RoleName
import com.techustle.db.User
import com.techustle.db.repository.CompanyRepository
import com.techustle.db.repository.RoleRepository
import com.techustle.db.repository.UserRepository
import com.techustle.models.EmployeeWorkLogRequest
import com.techustle.models.LoginRequest
import com.techustle.models.LoginResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.math.BigDecimal
import java.sql.Timestamp
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 21:15
 *
 */
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class FinanceControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var mapper: ObjectMapper
    @Autowired
    lateinit var roleRepository: RoleRepository
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var companyRepository: CompanyRepository

    var TOKEN: String? = null
    var userID: Long? = null
    var companyID: Long? = null

    @Test
    fun `test getting complete invoice data json and expect 200 status code`() {

        initDBData()
        getJWTForFinanceAdmin()

        var employeeWorkLog = EmployeeWorkLogRequest(0)


        mockMvc.get("/api/v1/finance/company/$companyID/invoice") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(employeeWorkLog)
            param("startDate", Date().toString())
            param("endDate", Date().toString())
            accept = MediaType.APPLICATION_JSON
            header("Authorization", "Bearer $TOKEN")
        }.andExpect {
            status { isOk }
        }
    }




    fun initDBData() {

        var roleLawyer = Role(1, RoleName.ROLE_LAWYER, listOf())
        var roleFinanceAdmin = Role(2, RoleName.ROLE_FINANCE_ADMIN, listOf())

        roleRepository.save(roleLawyer)
        roleRepository.save(roleFinanceAdmin)


        var user = User(1
                , "lawyer1@gmail.com"
                , Date()
                , "\$2a\$12\$nMLHAGaJRd/DBhVF5RvlyelxbhxmeHrfQL25eNojwHam26LVMzqoK".trimIndent().toByteArray()
                , "Rodney"
                , "Boachie"
                , Date()
                , true
                , listOf(roleRepository.findByRoleName(RoleName.ROLE_LAWYER)))

        var userFinance = User(2
                , "finance1@gmail.com"
                , Date()
                , "\$2a\$12\$nMLHAGaJRd/DBhVF5RvlyelxbhxmeHrfQL25eNojwHam26LVMzqoK".trimIndent().toByteArray()
                , "Kwaku"
                , "John"
                , Date()
                , true
                , listOf(roleRepository.findByRoleName(RoleName.ROLE_FINANCE_ADMIN)))

        val userLawyer = userRepository.save(user)
        userID = userLawyer.id

        userRepository.save(userFinance)

        var company = Company(1, "MTN", listOf())
        var company2 = Company(2, "gbc", listOf())

        var companySaved = companyRepository.save(company)
        companyID = companySaved.id

        companyRepository.save(company2)

    }

    fun getJWTForFinanceAdmin() {
        var loginRequest = LoginRequest(username = "finance1@gmail.com", password = "pass1234")

        val mvcResult: MvcResult = mockMvc.post("/api/v1/auth/signin") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(loginRequest)
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk }
        }.andReturn()

        val contentAsString: String = mvcResult.response.contentAsString
        val loginResponse: LoginResponse = mapper.readValue(contentAsString, LoginResponse::class.java)

        TOKEN = loginResponse.token
        userID = loginResponse.id

    }
}

