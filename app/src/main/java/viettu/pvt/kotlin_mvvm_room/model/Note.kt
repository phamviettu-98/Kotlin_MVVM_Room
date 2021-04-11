package viettu.pvt.kotlin_mvvm_room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(@ColumnInfo(name = "col_title") var tittle:String ="",
           @ColumnInfo(name = "col_desc") var descripsion:String="") {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "col_id")
    var Id:Int=0

}