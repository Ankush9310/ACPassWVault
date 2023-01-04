package com.ac10.acpaswvault.repository

import androidx.lifecycle.LiveData
import com.ac10.acpaswvault.model.BankDetailsItem
import com.ac10.acpaswvault.model.CardDetailsItem
import com.ac10.acpaswvault.model.LoginDetailsItem
import com.ac10.acpaswvault.roomdb.BankDao
import com.ac10.acpaswvault.roomdb.CardDao
import com.ac10.acpaswvault.roomdb.LoginDao
import javax.inject.Inject

class Repository
@Inject constructor(
    private val bankDao: BankDao,
    private val cardDao: CardDao,
    private val loginDao: LoginDao){

    fun insertBankDetails(bankDetailsItem: BankDetailsItem){
        bankDao.insertBankDetails(bankDetailsItem)
    }

    fun deleteBankDetails(accNumber: Long){
        bankDao.deleteBankDetails(accNumber)
    }

    fun getAllBankDetails():LiveData<List<BankDetailsItem>>{
        return bankDao.getAllBankDetails()
    }

    fun insertCardDetails(cardDetailsItem: CardDetailsItem){
        cardDao.insertCardDetails(cardDetailsItem)
    }

    fun deleteCardDetails(cardNumber: String){
        cardDao.deleteCardDetails(cardNumber)
    }

    fun getAllCardDetails() : LiveData<List<CardDetailsItem>>{
        return cardDao.getAllCardDetails()
    }

    fun insertLoginDetails(loginDetailsItem: LoginDetailsItem){
        loginDao.insertLoginDetails(loginDetailsItem)
    }

    fun deleteLoginDetails(id: String){
        loginDao.deleteLoginDetails(id)
    }

    fun getAllLoginDetails() : LiveData<List<LoginDetailsItem>>{
        return loginDao.getAllLoginDetails()
    }

    fun getCategoryLoginDetails(category : String) : LiveData<List<LoginDetailsItem>>{
        return loginDao.getCategoryLoginDetails(category)
    }


}