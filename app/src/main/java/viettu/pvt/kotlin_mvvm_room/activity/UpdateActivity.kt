package viettu.pvt.kotlin_mvvm_room.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import viettu.pvt.kotlin_mvvm_room.Adapter.NoteAdapter
import viettu.pvt.kotlin_mvvm_room.R
import viettu.pvt.kotlin_mvvm_room.ViewModel.NoteViewModel

class UpdateActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

    }


}