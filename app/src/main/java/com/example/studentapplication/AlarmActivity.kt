package com.example.studentapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class AlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val btnSetAlarm = findViewById<Button>(R.id.btnSetAlarm)

        btnSetAlarm.setOnClickListener {

            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MINUTE, 1)

            val intent = Intent(this@AlarmActivity, AlarmReceiver::class.java)

            val pendingIntent = PendingIntent.getBroadcast(
                this@AlarmActivity,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or
                        (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
                            PendingIntent.FLAG_IMMUTABLE else 0)
            )

            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )

            Toast.makeText(this, "Alarm set for 1 minute", Toast.LENGTH_SHORT).show()
        }
    }
}