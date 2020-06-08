package com.techustle.services

import org.junit.jupiter.api.Test
import java.sql.Timestamp
import java.text.SimpleDateFormat


/**
 * author: acerbk
 * Date: 2020-06-07
 * Time: 23:04
 */

class LawyerServiceTest {

    var lawyerService = LawyerService()

    @Test
    fun `find difference in hours between two timestamps`() {
        var result = lawyerService.findDifferenceInHours(convertStringToTimestamp("2023-03-07 07:39"),
                convertStringToTimestamp("2023-03-07 09:39"))
        print(result)
        assert(result == 2)
    }

    fun convertStringToTimestamp(timestampString: String): Timestamp {
        val datetimeFormatter1 = SimpleDateFormat(
                "yyyy-MM-dd hh:mm")
        val lFromDate1 = datetimeFormatter1.parse(timestampString)
        println("gpsdate :$lFromDate1")
        val fromTS1 = Timestamp(lFromDate1.time)
        return fromTS1
    }
}
