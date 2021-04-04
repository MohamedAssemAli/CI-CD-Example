package com.assem.ci_cd_example.data

import androidx.annotation.VisibleForTesting
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


/**
 * Created by Enzo Lizama Paredes on 7/26/20.
 * Contact: lizama.enzo@gmail.com
 */

@VisibleForTesting
val MIGRATION_1_2 = object : Migration(1, 2) {
  override fun migrate(database: SupportSQLiteDatabase) {
    database.execSQL("ALTER TABLE rwquotes ADD COLUMN 'stars' INTEGER NOT NULL DEFAULT 0")
  }
}

@VisibleForTesting
val MIGRATION_2_3 = object : Migration(2, 3) {
  override fun migrate(database: SupportSQLiteDatabase) {

  }
}