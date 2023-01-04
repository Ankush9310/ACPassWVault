package com.ac10.acpaswvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "BankDetailsTable")
data class BankDetailsItem (
    var bankName:String,
    @PrimaryKey
    var bankAccNumber:Long,
    var bankIFSC: String,
    var bankAddress:String )