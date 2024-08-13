package com.example.notes_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notes_app.databinding.NoteLayoutBinding
import com.example.notes_app.fragment.HomeFragmentDirections
import com.example.notes_app.model.Note

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val itemBinding : NoteLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.noteDescription == newItem.noteDescription &&
                    oldItem.noteTitle == newItem.noteTitle
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
      return NoteViewHolder(
          NoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
      )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]
        holder.itemBinding.noteTitle.text = currentNote.noteTitle
        holder.itemBinding.noteDescription.text = currentNote.noteDescription

        holder.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToEditNote(currentNote)
            it.findNavController().navigate(direction)
        }
    }

}