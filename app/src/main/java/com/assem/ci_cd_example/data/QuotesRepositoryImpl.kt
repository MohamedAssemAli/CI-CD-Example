package com.assem.ci_cd_example.data

import android.app.Application
import com.assem.ci_cd_example.data.Quote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


/**
 * Created by Enzo Lizama Paredes on 7/24/20.
 * Contact: lizama.enzo@gmail.com
 */

class QuotesRepositoryImpl(application: Application) : QuotesRepository, CoroutineScope {

  private val quotesDao: QuotesDao
  private val job: Job

  override val coroutineContext: CoroutineContext
    get() = Dispatchers.Main + job

  init {
    val database = RWQuotesDatabase.getInstance(application.applicationContext)
    quotesDao = database!!.quotesDao()
    job = Job()
  }

  override fun insert(quote: Quote) {
    launch(Dispatchers.IO) {
      quotesDao.insertQuote(quote)
    }
  }

  override fun update(quote: Quote) {
    launch(Dispatchers.IO) { quotesDao.updateQuote(quote) }
  }

  override fun delete(quote: Quote) {
    launch(Dispatchers.IO) { quotesDao.deleteQuote(quote) }
  }

  override fun getQuotes(): Flow<List<Quote>> {
    return quotesDao.getQuotes()
  }

}