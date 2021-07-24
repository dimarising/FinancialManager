package com.example.managerfinansowy.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.managerfinansowy.data.ListItem
import com.example.managerfinansowy.databinding.StackinformBinding

class ViewHolder(
    private val layoutBinding: StackinformBinding
) : RecyclerView.ViewHolder(layoutBinding.root) {

    fun bind(list: ListItem) = with(layoutBinding) {
        shopTextView.text = list.shop.toString()
        categoryTextView.text = list.category.toString()
        amountTextView.text = list.amount.toString()
        dataTextView.text = list.date.toString()

    }
}
