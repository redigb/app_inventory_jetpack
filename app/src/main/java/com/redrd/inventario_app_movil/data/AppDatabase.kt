package com.redrd.inventario_app_movil.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.redrd.inventario_app_movil.data.dao.ArtefactoDao
import com.redrd.inventario_app_movil.data.dao.VehiculoDao
import com.redrd.inventario_app_movil.data.entidades.Artefacto
import com.redrd.inventario_app_movil.data.entidades.Vehiculo


@Database(entities = [Artefacto::class, Vehiculo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
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