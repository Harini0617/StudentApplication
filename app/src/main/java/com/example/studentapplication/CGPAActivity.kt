package com.example.studentapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapplication.databinding.ActivityCgpaactivityBinding

class CGPAActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCgpaactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCgpaactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val cgpaText = binding.etCgpa.text.toString()

            if (cgpaText.isEmpty()) {
                Toast.makeText(this, "Please enter CGPA", Toast.LENGTH_SHORT).show()
            } else {
                val cgpa = cgpaText.toFloat()
                Toast.makeText(this, "Your CGPA is $cgpa", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
