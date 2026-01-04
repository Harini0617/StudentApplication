package com.example.studentapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAttendance.setOnClickListener {
            startActivity(Intent(this, AttendanceActivity::class.java))
        }

        binding.btnCgpa.setOnClickListener {
            startActivity(Intent(this, CGPAActivity::class.java))
        }

        binding.btnTodo.setOnClickListener {
            startActivity(Intent(this, TodoActivity::class.java))
        }

        binding.btnAlarm.setOnClickListener {
            startActivity(Intent(this, AlarmActivity::class.java))
        }
    }
}