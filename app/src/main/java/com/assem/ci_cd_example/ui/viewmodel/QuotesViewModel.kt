package com.assem.ci_cd_example.ui.viewmodel

import androidx.lifecycle.*
import com.assem.ci_cd_example.data.Quote
import com.assem.ci_cd_example.data.QuotesRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


/**
 * Created by Enzo Lizama Paredes on 7/24/20.
 * Contact: lizama.enzo@gmail.com
 */

class QuotesViewModel(private val repository: QuotesRepository) : ViewModel() {

  private val _dataLoading = MutableLiveData<Boolean>()
  val dataLoading: LiveData<Boolean> = _dataLoading

  fun insertQuote(quote: Quote) {
    _dataLoading.postValue(true)
    viewModelScope.launch {
      repository.insert(quote)
    }
    _dataLoading.postValue(false)
  }

  fun updateQuote(quote: Quote) {
    _dataLoading.postValue(true)
    viewModelScope.launch {
      repository.update(quote)
    }
    _dataLoading.postValue(false)
  }

  fun delete(quote: Quote) {
    _dataLoading.postValue(true)
    viewModelScope.launch {
      repository.delete(quote)
    }
    _dataLoading.postValue(false)
  }

  fun getAllQuotes(): LiveData<List<Quote>>  = liveData {
    _dataLoading.postValue(true)
    repository.getQuotes().collect { quotes ->
      _dataLoading.postValue(false)
      emit(quotes)
    }
  }

}