package com.techustle.db

import com.fasterxml.jackson.annotation.JsonFormat

/**
 *
 * author: acerbk
 * Date: 2020-06-03
 * Time: 03:55
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class Sex(val sexType:Int) {
    MALE(1),
    FEMALE(2)
}
