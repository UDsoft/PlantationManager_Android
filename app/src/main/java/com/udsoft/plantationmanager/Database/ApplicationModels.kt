package com.udsoft.plantationmanager.Database

import android.location.Location
import java.util.*

/**
 * Collection of Model used in this Application PlantationManager.
 */

/**
 * @param date harvest date. By default current date.
 * @param plantationName name of the plantation
 * @param weight the harvest weight
 * @param pricePerTon the selling price of as per Ton
 * @param harvestValue weight * pricePerTon. Money on hand.
 */
data class Harvest(var date: Date = Calendar.getInstance().time,
                   var plantationName: Plantation,
                   var weight: Double,
                   var pricePerTon: Double,
                   var harvestValue: Double,
                   var harvestExpenses: Expenses?)


/**
 * @param date expenses date.By default current date.
 * @param typeOfExpenses type of expenses: fertiliser,harvest, drainage,replant,other
 * @param description simple description for the expenses. Default empty.
 * @param amountOfExpenses the total expenses
 */
data class Expenses(var date: Date = Calendar.getInstance().time,
                    var typeOfExpenses: String,
                    var description: String = "",
                    var amountOfExpenses: Double)


/**
 * @param name : name of the plantation
 * @param geolocation : location of the plantation. Can be empty
 * @param description : simple description of the plantation
 * @param area : size of the plantation.
 */
data class Plantation(var name: String,
                      var geolocation: Location?,
                      var description: String,
                      var area: Double?)

/**
 * @description user model
 */
data class user(var firstName: String,
                var lastName: String,
                var email: String,
                var password: String,
                var dob: String)