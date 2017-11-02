package com.udsoft.plantationmanager.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class HarvestDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "HarvestDatabase", null, 1) {

    companion object {
        private var instance: HarvestDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): HarvestDatabaseOpenHelper {
            if (instance == null) {
                instance = HarvestDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {

        db.createTable("Harvest",
                true,
                "_id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "date" to TEXT + NOT_NULL,
                "plantation" to TEXT + NOT_NULL,
                "weight" to REAL + NOT_NULL,
                "pricePerTon" to REAL + NOT_NULL,
                "harvestValue" to REAL + NOT_NULL)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

/* This enable simpler code required while using the data base.
 * harvestDB.use{
 *  execute code to do with the database.
 * }
 *
 */
val Context.harvestDB: HarvestDatabaseOpenHelper
    get() = HarvestDatabaseOpenHelper.getInstance(applicationContext)