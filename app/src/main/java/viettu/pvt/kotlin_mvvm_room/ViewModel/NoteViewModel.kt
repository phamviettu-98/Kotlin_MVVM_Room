package viettu.pvt.kotlin_mvvm_room.ViewModel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import viettu.pvt.kotlin_mvvm_room.database.responsitory.NoteResponsity
import viettu.pvt.kotlin_mvvm_room.model.Note
import java.lang.IllegalArgumentException

class NoteViewModel(application: Application): ViewModel() {

    private  val noteReponsity:NoteResponsity = NoteResponsity(application)
    fun insertNote(note:Note) = viewModelScope.launch {
        noteReponsity.insertNote(note)
    }
    fun  updateNote(note: Note) = viewModelScope.launch {
        noteReponsity.updateNote(note)
    }
    fun deleteNote(note: Note) = viewModelScope.launch {
        noteReponsity.deleteNote(note)

    }
    fun getAllNote(): LiveData<List<Note>> = noteReponsity.getAllNote()
    class NoteViewHolderFactory(private  val application: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            if ( modelClass.isAssignableFrom(NoteViewModel::class.java)){
                @Suppress("CHECK_CAST")
                return NoteViewModel(application) as T
            }
            throw  IllegalArgumentException("Unable contuctor ViewModel")
        }

    }
}