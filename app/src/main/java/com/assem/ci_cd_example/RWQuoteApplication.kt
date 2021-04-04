package com.assem.ci_cd_example

import android.app.Application
import timber.log.Timber


/**
 * Created by Enzo Lizama Paredes on 7/24/20.
 * Contact: lizama.enzo@gmail.com
 */

class RWQuoteApplication : Application(){

  override fun onCreate() {
    super.onCreate()
    if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
  }
}