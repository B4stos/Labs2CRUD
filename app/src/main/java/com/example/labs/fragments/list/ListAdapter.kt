package com.example.labs.fragments.list

import android.graphics.Color
import android.view.*
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.R
import com.example.labs.data.entities.Note



class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var notesList = emptyList<Note>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = notesList[position]
        holder.itemView.findViewById<TextView>(R.id.note_txt).text = currentItem.note

        if(position%2 == 0)
            holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setBackgroundColor(Color.parseColor("#d6d4e0"))
        else
            holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setBackgroundColor(Color.parseColor("#b8a9c9"))

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)



        }
    }

    fun setData(note: List<Note>){
        this.notesList = note
        notifyDataSetChanged()
    }
}