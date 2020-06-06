package com.techustle

//import org.springframework.http.RequestEntity.get
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


/**
 *
 * author: acerbk
 * Date: 2020-06-06
 * Time: 02:44
 *
 */
class UserAccountControllerTest {

    private lateinit var mvc: MockMvc

    fun setUp(){

    }

    @Test
    fun test_jwt_creation_success(){
        mvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

    }
}
