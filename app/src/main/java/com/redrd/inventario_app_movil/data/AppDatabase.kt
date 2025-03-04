package com.redrd.inventario_app_movil.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.redrd.inventario_app_movil.data.dao.ArtefactoDao
import com.redrd.inventario_app_movil.data.dao.VehiculoDao

abstract class AppDatabase: RoomDatabase() {
    abstract fun artefactoDao(): ArtefactoDao
    abstract fun vehiculoDao(): VehiculoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "inventario_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}