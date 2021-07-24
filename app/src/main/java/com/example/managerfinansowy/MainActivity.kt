package com.example.managerfinansowy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.managerfinansowy.adapter.AddToMainAdapter
import com.example.managerfinansowy.data.ListItem
//import com.example.managerfinansowy.adapter.AddOrEdirAdapter
//import com.example.managerfinansowy.adapter.StackinfoAdapter
import com.example.managerfinansowy.databinding.ActivityMainBinding
import com.example.managerfinansowy.model.Shared
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val stackinfoAdapter by lazy { AddToMainAdapter() }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.stackList.apply {
            adapter = stackinfoAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume(){
        super.onResume()
        stackinfoAdapter.refresh()
        binding.moneyPlus.setText(getMonthIncome().toString())
        binding.moneyMinus.setText("- "+getMonthExpenses().toString())
    }

    fun openAddActivity(view: View){
        startActivity(Intent(this, AddOrEditActivity::class.java))
    }

    fun openChartActivity(view: View){
        startActivity(Intent(this, ChartActivity::class.java))
    }




    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthIncome() : Double {
        var income : Double = 0.0
        val month : Int = LocalDate.now().monthValue
        val year : Int = LocalDate.now().year
        println(month)
        for(ins in Shared.expensesList){
            if(ins.date.monthValue == month && ins.date.year == year)
                if(ins.amount > 0)
                    income += ins.amount

        }
        return income
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthExpenses() : Double {
        var expenses : Double = 0.0
        val month : Int = LocalDate.now().monthValue
        val year : Int = LocalDate.now().year
        println(month)
        for(ins in Shared.expensesList){
            if(ins.date.monthValue == month && ins.date.year == year)
                if(ins.amount < 0)
                    expenses -= ins.amount

        }
        return expenses
    }



}
