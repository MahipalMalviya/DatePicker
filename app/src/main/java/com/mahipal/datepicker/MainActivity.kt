package com.mahipal.datepicker

import android.annotation.SuppressLint
import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.widget.NumberPicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_number_picker.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_number_picker)
            dialog.show()

            val dayNumberPicker = dialog.findViewById<NumberPicker>(R.id.np_day)
            val monthNumberPicker = dialog.findViewById<NumberPicker>(R.id.np_month)
            val yearNumberPicker = dialog.findViewById<NumberPicker>(R.id.np_year)

            val btnDialogCancel = dialog.findViewById<AppCompatButton>(R.id.btn_dialog_cancel)
            val btnGetDate = dialog.findViewById<AppCompatButton>(R.id.btn_get_date)

            dayNumberPicker.minValue = getMinDayOfMonth()
            dayNumberPicker.maxValue = getMaxDayOfMonth()
            dayNumberPicker.value = getCurrentDayOfMonth()

            monthNumberPicker.minValue = 1
            monthNumberPicker.maxValue = 12
            monthNumberPicker.value = getCurrentMonth().plus(1)

            yearNumberPicker.minValue = getCurrentYear().minus(20)
            yearNumberPicker.maxValue = getCurrentYear().plus(20)
            yearNumberPicker.value = getCurrentYear()

            btnDialogCancel.setOnClickListener {
                dialog.cancel()
            }

            btnGetDate.setOnClickListener {
                tv_date.text = "${dayNumberPicker.value}/${monthNumberPicker.value}/${yearNumberPicker.value}"
                dialog.cancel()
            }
        }
    }

    fun getCurrentDayOfMonth() : Int {
        val c = Calendar.getInstance()
        return c.get(Calendar.DAY_OF_MONTH)
    }

    fun getCurrentMonth() : Int {
        val c = Calendar.getInstance()
        return c.get(Calendar.MONTH)
    }

    fun getCurrentYear() : Int {
        val c = Calendar.getInstance()
        return c.get(Calendar.YEAR)
    }

    fun getMaxDayOfMonth(): Int {
        val c = Calendar.getInstance()
        return c.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    fun getMinDayOfMonth(): Int {
        val c = Calendar.getInstance()
        return c.getActualMinimum(Calendar.DAY_OF_MONTH)
    }
}
