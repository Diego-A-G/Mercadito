package com.example.mercadito.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mercadito.dao.ICategoryDAO
import com.example.mercadito.dao.IHistoricDAO
import com.example.mercadito.dao.IItemDAO
import com.example.mercadito.dao.IPeriodDAO
import com.example.mercadito.dao.IShopListDAO
import com.example.mercadito.dao.IUserDAO
import com.example.mercadito.entities.CategoryEntity
import com.example.mercadito.entities.HistoricEntity
import com.example.mercadito.entities.ItemEntity
import com.example.mercadito.entities.PeriodEntity
import com.example.mercadito.entities.ShopListEntity
import com.example.mercadito.entities.UserEntity

// Todo converters para cada entidad
// estructura de llaves dela bd

@Database(entities = [
    UserEntity::class,
    ShopListEntity::class,
    CategoryEntity::class,
    ItemEntity::class,
    HistoricEntity::class,
    PeriodEntity::class
                     ], version = 1)
@TypeConverters(DateConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): IUserDAO
    abstract fun getShopListDao(): IShopListDAO
    abstract fun getCategoryDao(): ICategoryDAO
    abstract fun getItemDao(): IItemDAO
    abstract fun getHistoricShopDao(): IHistoricDAO
    abstract fun getPeriodDao(): IPeriodDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}