package com.dorisoft.rental

/**
 * Created by Alidad on 1/23/14.
 */
class Organization {
    String name
    static hasMany = [rentalProperties :RentalProperty]

    static constraints = {
    }
}
