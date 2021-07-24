package com.example.managerfinansowy

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.managerfinansowy.data.ListItem
import com.example.managerfinansowy.databinding.ActivityAddOrEditBinding
import com.example.managerfinansowy.model.Shared
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AddOrEditActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddOrEditBinding.inflate(layoutInflater) }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{
            val stack = ListItem(
                    binding.shopText.text.toString(),
                    binding.amountTextNum3.text.toString(),
                    binding.amountTextNum.text.toString().toDouble(),
                    parsetoDate(binding.dateText.text.toString())

            )
            Shared.expensesList.add(stack)
            Toast.makeText(this, "Dodano nowy wpis!", Toast.LENGTH_LONG).show()
            finish()
       }

    }

    fun openAddActivity(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun parsetoDate(toString: String): LocalDate {

        val formatter = DateTimeFormatter.ofPattern("dd.MM.yy")
        val date = LocalDate.parse(toString, formatter)
        return date
    }


}