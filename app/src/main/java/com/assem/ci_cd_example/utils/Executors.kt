package com.assem.ci_cd_example.utils

import java.util.concurrent.Executors


/**
 * Created by Enzo Lizama Paredes on 7/24/20.
 * Contact: lizama.enzo@gmail.com
 */


private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

/**
 * Utility method to run blocks on a dedicated background thread, used for io/database work.
 */
fun ioThread(f : () -> Unit) {
  IO_EXECUTOR.execute(f)
}