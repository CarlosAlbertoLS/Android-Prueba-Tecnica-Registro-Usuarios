package com.sonder.roomapplication.register

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.DayOfWeek

class DatePickerfragment(val listener: (day:Int, month:Int, year:Int) -> Unit): DialogFragment(),
DatePickerDialog.OnDateSetListener{
    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfWeek: Int) {
        listener(dayOfWeek,month,year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val picker = DatePickerDialog(activity as Context, this, year, month, day)
        return picker
    }
}