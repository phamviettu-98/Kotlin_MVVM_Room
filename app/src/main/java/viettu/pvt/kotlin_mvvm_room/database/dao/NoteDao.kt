package viettu.pvt.kotlin_mvvm_room.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import viettu.pvt.kotlin_mvvm_room.model.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note :Note)
    @Update
    suspend fun update(note: Note)
    @Delete
    suspend fun delete(note: Note)

    //livedat get note
    @Query("select * from note_table")
    fun  getAllNote(): LiveData<List<Note>>

    @Query("select * from note_table where col_title = :title")
    fun  getNoteByTitle(title:String):LiveData<List<Note>>

}