package viettu.pvt.kotlin_mvvm_room.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import viettu.pvt.kotlin_mvvm_room.R
import viettu.pvt.kotlin_mvvm_room.model.Note

class NoteAdapter(private val context:Context, private  val onclicK:(Note)->Unit,
                  private val onDelete:(Note)->Unit
)   : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notes:List<Note> = listOf()


    inner class NoteViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        private val txt_Title : TextView = itemView.findViewById(R.id.tv_title) as TextView
        private val txt_desc : TextView = itemView.findViewById(R.id.tv_desc) as TextView
        private val btn_delete:ImageView = itemView.findViewById(R.id.imageView) as ImageView
        private val layout_item:ConstraintLayout = itemView.findViewById(R.id.layout_item)
          fun  onBind(note: Note){
              txt_Title.text = note.tittle
              txt_desc.text = note.descripsion
              btn_delete.setOnClickListener { onDelete(note) }
              layout_item.setOnClickListener { onclicK(note) }

          }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
      val itemView = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
      holder.onBind(notes[position])
    }

    override fun getItemCount(): Int {
      return  notes.size
    }
    fun  setNote(notes:List<Note>){
        this.notes = notes
        notifyDataSetChanged()

    }
}