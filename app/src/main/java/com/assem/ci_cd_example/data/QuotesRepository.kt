package com.assem.ci_cd_example.data

import com.assem.ci_cd_example.data.Quote
import kotlinx.coroutines.flow.Flow


/**
 * Created by Enzo Lizama Paredes on 7/24/20.
 * Contact: lizama.enzo@gmail.com
 */


interface QuotesRepository {

  fun insert(quote: Quote)

  fun update(quote: Quote)

  fun delete(quote: Quote)

  fun getQuotes(): Flow<List<Quote>>
}