package viettu.pvt.kotlin_mvvm_room.database.responsitory

import android.app.Application
import androidx.lifecycle.LiveData
import viettu.pvt.kotlin_mvvm_room.database.dao.NoteDao
import viettu.pvt.kotlin_mvvm_room.database.dao.NoteDatabes
import viettu.pvt.kotlin_mvvm_room.model.Note

class NoteResponsity(app:Application) {
    private  val noteDao :NoteDao
    init {
        val noteDatabase:NoteDatabes = NoteDatabes.getIntance(app)
        noteDao = noteDatabase.getNoteDao()
    }
    suspend fun insertNote(note:Note) = noteDao.insert(note)
    suspend fun  updateNote(note: Note) = noteDao.update(note)
    suspend fun deleteNote(note: Note) = noteDao.delete(note)
    fun getAllNote():LiveData<List<Note>> =noteDao.getAllNote()
}