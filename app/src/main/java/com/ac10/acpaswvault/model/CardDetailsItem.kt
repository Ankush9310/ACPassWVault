package com.ac10.acpaswvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "CardDetailsTable")
data class CardDetailsItem (
    var cardHolder:String,
    var cardIssuer:String,
    @PrimaryKey
    var cardNumber:String,
    var cardExpiryMonth:String,
    var cardExpiryYear:String,
    var cardCVV:String
    )