package com.example.studentapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AttendanceActivity : AppCompatActivity() {

    private var presentCount = 0
    private var totalCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnPresent = findViewById<Button>(R.id.btnPresent)
        val btnAbsent = findViewById<Button>(R.id.btnAbsent)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnPresent.setOnClickListener {
            presentCount++
            totalCount++
            updateResult(tvResult)
        }

        btnAbsent.setOnClickListener {
            totalCount++
            updateResult(tvResult)
        }

        btnReset.setOnClickListener {
            presentCount = 0
            totalCount = 0
            updateResult(tvResult)
        }
    }

    private fun updateResult(tv: TextView) {
        if (totalCount == 0) {
            tv.text = "Attendance: 0%"
        } else {
            val percentage = (presentCount * 100) / totalCount
            tv.text = "Attendance: $percentage%"
        }
    }
}