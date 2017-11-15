package com.udsoft.plantationmanager.Database

/**
 * Holds all the Table properties of the each database table
 * 1. HarvestTable
 * 2. ExpensesTable
 * 3. PlantationTable
 */
object HarvestTable {
    val NAME = "Harvest"
    val ID = "_id"
    val DATE = "date"
    val WEIGHT = "weight"
    val PRICE_PER_TON = "price per ton"
    val HARVEST_VALUE = "harvest value"
    val PLANTATION_ID = "plantation"
    val EXPENSES_GROUP = "expenses_group_id"
}

object ExpensesTable {
    val NAME = "Expenses"
    val ID = "_id"
    val DATE = "date"
    val TYPE = "type"
    val DESCRIPTION = "description"
    val VALUE = "value"
    val EXPENSES_GROUP = "expenses_group_id"

}

object PlantationTable {
    val NAME = "Plantation"
    val ID = "_id"
    val GEOLOCATION = "geolocation"
    val DESCRIPTION = "description"
    val AREA = "area"
    val AREA_UNIT = "area_unit"
    val EXPENSES_GROUP = "expenses_group_id"
}

object ExpensesGroupTable {
    val NAME = "ExpensesGroup"
    val ID = "_id"
}