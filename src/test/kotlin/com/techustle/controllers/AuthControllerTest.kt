package com.techustle.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.techustle.models.LoginRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post


/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 02:44
 *
 */
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var mapper: ObjectMapper

    fun setUp() {

    }

    @Test
    fun `test jwt creation with wrong credentials and expect status code 401`() {

        var loginRequest = LoginRequest(username = "law@gmail.com", password = "pass")

        mockMvc.post("/api/v1/auth/signin") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(loginRequest)
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isUnauthorized }
        }
    }
}
