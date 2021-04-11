package viettu.pvt.kotlin_mvvm_room.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import viettu.pvt.kotlin_mvvm_room.Adapter.NoteAdapter
import viettu.pvt.kotlin_mvvm_room.R
import viettu.pvt.kotlin_mvvm_room.ViewModel.NoteViewModel
import viettu.pvt.kotlin_mvvm_room.model.Note

class MainActivity : AppCompatActivity() {

    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(this, NoteViewModel.NoteViewHolderFactory(this.application))[NoteViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initsControls()
        initsEvents()
    }
    private fun initsEvents() {
          btn_add.setOnClickListener(){
              val note = Note(edt_note_title.text.toString(),edt_note_decs.text.toString())
              noteViewModel.insertNote(note)
          }
    }

    private fun initsControls() {
        var adapter: NoteAdapter = NoteAdapter(this@MainActivity, onItemClick, onClickDelete)
        rv_view.setHasFixedSize(true)
        rv_view.layoutManager = LinearLayoutManager(this)
        rv_view.adapter = adapter
        noteViewModel.getAllNote().observe(this, Observer { adapter.setNote(it) })
    }
    private val  onItemClick:(Note)->Unit={

    }
    private val onClickDelete:(Note)->Unit={
     noteViewModel.deleteNote(it)
    }
}