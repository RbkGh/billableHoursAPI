package com.techustle.db.repository

import com.techustle.db.Company
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 *
 * author: acerbk
 * Date: 2020-06-07
 * Time: 00:02
 *
 */
@Repository
interface CompanyRepository : CrudRepository<Company, Long> {
}
