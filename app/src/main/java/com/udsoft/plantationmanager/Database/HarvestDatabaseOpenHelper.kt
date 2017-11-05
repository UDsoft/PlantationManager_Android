package com.udsoft.plantationmanager.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.udsoft.plantationmanager.App
import org.jetbrains.anko.db.*

class HarvestDatabaseOpenHelper(ctx: Context = App.instance()) : ManagedSQLiteOpenHelper(ctx, DB_NAME, FACTORY, DB_VERSION) {

    companion object {
        val instance by lazy { HarvestDatabaseOpenHelper() }
        internal val DB_NAME = "PlantationManager.db"
        internal val DB_VERSION = 1
        internal val FACTORY = null

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
    }


}

/* This enable simpler code required while using the data base.
 * harvestDB.use{
 *  execute code to do with the database.
 * }
 *
 */
val Context.harvestDB: HarvestDatabaseOpenHelper
    get() = HarvestDatabaseOpenHelper()