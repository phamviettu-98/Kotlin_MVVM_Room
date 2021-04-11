package viettu.pvt.kotlin_mvvm_room.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import viettu.pvt.kotlin_mvvm_room.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabes : RoomDatabase() {
    abstract fun getNoteDao() :NoteDao
    companion object{
        // co thay doi cos the nhin thay gia tri
        @Volatile
        private var intance : NoteDatabes?=null
        fun getIntance(context: Context):NoteDatabes{
            if (intance== null){
                intance = Room.databaseBuilder(context, NoteDatabes::class.java,"NoteDatabase").build()

            }
            return intance!!
        }

    }
}