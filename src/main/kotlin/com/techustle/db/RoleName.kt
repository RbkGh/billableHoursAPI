package com.techustle.db

import com.fasterxml.jackson.annotation.JsonFormat

/**
 *
 * author: acerbk
 * Date: 2020-06-03
 * Time: 04:31
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class RoleName(val roleDescription: String) {
    ROLE_LAWYER("Lawyer"),
    ROLE_FINANCE_ADMIN("Finance Admin");
}
