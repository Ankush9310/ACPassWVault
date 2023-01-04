package com.ac10.acpaswvault.hilt

import android.app.Application
import androidx.room.Room
import com.ac10.acpaswvault.roomdb.BankDao
import com.ac10.acpaswvault.roomdb.CardDao
import com.ac10.acpaswvault.roomdb.LoginDao
import com.ac10.acpaswvault.roomdb.PasswordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application):PasswordDatabase{
        return Room.databaseBuilder(
            application,
            PasswordDatabase::class.java,
            "MyDatabase")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideBankDao(passwordDatabase: PasswordDatabase):BankDao{
        return passwordDatabase.bankDao()
    }

    @Provides
    fun provideLoginDao(passwordDatabase: PasswordDatabase):LoginDao{
        return passwordDatabase.loginDao()
    }

    @Provides
    fun provideCardDao(passwordDatabase: PasswordDatabase):CardDao{
        return passwordDatabase.cardDao()
    }

}