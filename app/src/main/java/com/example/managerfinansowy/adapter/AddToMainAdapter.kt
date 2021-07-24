package com.example.managerfinansowy.adapter

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.managerfinansowy.AddOrEditActivity
import com.example.managerfinansowy.data.ListItem
import com.example.managerfinansowy.model.Shared
import com.example.managerfinansowy.databinding.StackinformBinding

class AddToMainAdapter : RecyclerView.Adapter<ViewHolder>() {
    private val allinfList = Shared.expensesList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StackinformBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding).also { holder ->
            binding.root.setOnLongClickListener {
                val alertDialog: AlertDialog.Builder = AlertDialog.Builder(holder.itemView.context)
                alertDialog.setMessage("Usunąć tą komórkę?")
                alertDialog.setPositiveButton(
                        "Oczywiście!"
                ) { _, _ ->
                    remove(holder.layoutPosition)
                }
                alertDialog.setNegativeButton(
                        "O nie"
                ) { _, _ -> }
                val alert: AlertDialog = alertDialog.create()
                alert.setCanceledOnTouchOutside(false)
                alert.show()

                true }

        }

    }

    override fun getItemCount(): Int = allinfList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(allinfList[position])
    }



    fun refresh() = notifyDataSetChanged()

    fun add(list: ListItem) {
        allinfList.add(list)
        notifyItemInserted(allinfList.size -1)
    }

    fun remove(position: Int) {
        if (position >= 0 && position < allinfList.size) {
            allinfList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

}