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
    val PLANTATION = "plantation"
    val EXPENSES = "expenses"
}

object ExpensesTable {
    val NAME = "Expenses"
    val ID = "_id"
    val DATE = "date"
    val TYPE = "type"
    val DESCRIPTION = "description"
    val VALUE = "value"

}

