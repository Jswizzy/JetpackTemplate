package com.example.jetpacktemplate.main

import androidx.lifecycle.LiveData
import androidx.room.*
import android.content.Context

/**
 * Title represents the title fetched from the network
 */
@Entity
data class Title constructor(val title: String, @PrimaryKey val id: Int = 0)

/***
 * Very small database that will hold one title
 */
@Dao
interface TitleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTitle(title: Title)

    @Query("select * from Title where id = 0")
    fun loadTitle(): LiveData<Title>
}

/**
 * MainDatabase provides a reference to the dao to repositories
 */
@Database(entities = [Title::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract val titleDao: TitleDao
}

private lateinit var INSTANCE: MainDatabase

/**
 * Instantiate a database from a context.
 */
fun getDatabase(context: Context): MainDatabase {
    synchronized(MainDatabase::class) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room
                .databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "titles_db"
                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}