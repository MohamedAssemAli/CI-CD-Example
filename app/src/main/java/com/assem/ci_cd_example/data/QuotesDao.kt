package com.assem.ci_cd_example.data

import androidx.room.*
import com.assem.ci_cd_example.data.Quote
import kotlinx.coroutines.flow.Flow


/**
 * Created by Enzo Lizama Paredes on 7/23/20.
 * Contact: lizama.enzo@gmail.com
 */

@Dao
interface QuotesDao {

  @Query("SELECT * FROM rwquotes ORDER BY id DESC")
  fun getQuotes(): Flow<List<Quote>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertQuote(quote: Quote) : Long

  @Update
  fun updateQuote(quote: Quote): Int

  @Delete
  fun deleteQuote(quote: Quote): Int
}