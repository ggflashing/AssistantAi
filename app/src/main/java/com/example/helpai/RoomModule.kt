package com.example.helpai


import androidx.room.Room
import android.content.Context
import com.example.helpai.data.DataSourse.Dao
import com.example.helpai.data.DataSourse.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideChatDatabase(
        @ApplicationContext context: Context
    ): DataBase {

        return Room.databaseBuilder(
            context,
            DataBase::class.java,
            "chat_database"
        ).build()
    }

    @Provides
    fun provideChatDao(database: DataBase): Dao {
        return database.Dao()
    }

}