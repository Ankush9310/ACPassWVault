package com.ac10.acpaswvault.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ac10.acpaswvault.model.BankDetailsItem
import com.ac10.acpaswvault.model.CardDetailsItem
import com.ac10.acpaswvault.model.LoginDetailsItem

@Database(
    entities = [BankDetailsItem::class, LoginDetailsItem::class, CardDetailsItem::class],
    version = 1,
    exportSchema = false
)
abstract class PasswordDatabase:RoomDatabase() {

    abstract fun bankDao():BankDao
    abstract fun cardDao():CardDao
    abstract fun loginDao():LoginDao

}