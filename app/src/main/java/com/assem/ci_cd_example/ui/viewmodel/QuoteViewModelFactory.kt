@file:Suppress("UNCHECKED_CAST")

package com.assem.ci_cd_example.ui.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assem.ci_cd_example.data.QuotesRepository


/**
 * Created by Enzo Lizama Paredes on 7/24/20.
 * Contact: lizama.enzo@gmail.com
 */

@SuppressLint("UNCHECKED_CAST")
class QuoteViewModelFactory(
    private val repository: QuotesRepository
) : ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return QuotesViewModel(repository) as T
  }

}