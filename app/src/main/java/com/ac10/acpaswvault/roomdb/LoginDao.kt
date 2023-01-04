package com.ac10.acpaswvault.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ac10.acpaswvault.model.LoginDetailsItem

@Dao
interface LoginDao {

    @Insert
    fun insertLoginDetails(loginDetails : LoginDetailsItem)

    @Query("DELETE FROM LoginDetailsItem WHERE id = :id")
    fun deleteLoginDetails(id : String)

    @Query("SELECT * FROM LoginDetailsItem")
    fun getAllLoginDetails() : LiveData<List<LoginDetailsItem>>

    @Query("SELECT * FROM LoginDetailsItem WHERE loginCategory = :category")
    fun getCategoryLoginDetails(category : String) : LiveData<List<LoginDetailsItem>>

}