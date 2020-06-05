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
    ROLE_LAWYER("ROLE_LAWYER"),
    ROLE_FINANCE_ADMIN("ROLE_FINANCE_ADMIN");

    companion object {
        @JvmStatic
        fun getFriendlyRoleName(roleName: RoleName): String {
            var friendlyRoleName: String;
            when (roleName) {
                ROLE_LAWYER -> {
                    friendlyRoleName = "Lawyer"
                }
                ROLE_FINANCE_ADMIN -> {
                    friendlyRoleName = "Finance Admin"
                }
            }
            return friendlyRoleName
        }
    }
}
