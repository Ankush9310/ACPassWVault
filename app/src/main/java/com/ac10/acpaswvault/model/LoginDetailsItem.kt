package com.ac10.acpaswvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoginDetailsItem (
    @PrimaryKey var id:String,
    var loginName:String,
    var loginEmail:String,
    var loginPassword:String,
    var loginNotes:String,
    var loginCategory:String)