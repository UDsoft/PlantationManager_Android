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

        with(receiver = db) {
            createTable(HarvestTable.NAME,
                    true,
                    HarvestTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT + UNIQUE,
                    HarvestTable.DATE to TEXT + NOT_NULL,
                    HarvestTable.PLANTATION_ID to INTEGER + NOT_NULL,
                    HarvestTable.WEIGHT to REAL + NOT_NULL,
                    HarvestTable.PRICE_PER_TON to REAL + NOT_NULL,
                    HarvestTable.HARVEST_VALUE to REAL + NOT_NULL,
                    HarvestTable.EXPENSES_GROUP to INTEGER + NOT_NULL,
                    FOREIGN_KEY(HarvestTable.EXPENSES_GROUP, ExpensesGroupTable.NAME, ExpensesGroupTable.ID))


            createTable(
                    ExpensesTable.NAME,
                    true,
                    ExpensesTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                    ExpensesTable.DATE to TEXT + NOT_NULL,
                    ExpensesTable.TYPE to TEXT + NOT_NULL,
                    ExpensesTable.DESCRIPTION to TEXT,
                    ExpensesTable.VALUE to REAL + NOT_NULL,
                    ExpensesTable.EXPENSES_GROUP to INTEGER + NOT_NULL,
                    FOREIGN_KEY(ExpensesTable.EXPENSES_GROUP, ExpensesGroupTable.NAME, ExpensesGroupTable.ID))

            createTable(PlantationTable.NAME,
                    true,
                    PlantationTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                    PlantationTable.GEOLOCATION to TEXT,
                    PlantationTable.DESCRIPTION to TEXT,
                    PlantationTable.AREA to REAL,
                    PlantationTable.AREA_UNIT to TEXT,
                    PlantationTable.EXPENSES_GROUP to INTEGER + NOT_NULL,
                    FOREIGN_KEY(PlantationTable.EXPENSES_GROUP, ExpensesGroupTable.NAME, ExpensesGroupTable.ID))

            createTable(ExpensesGroupTable.NAME,
                    true,
                    ExpensesGroupTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT + UNIQUE)
        }

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