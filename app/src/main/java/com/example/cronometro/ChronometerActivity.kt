package com.example.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import com.example.cronometro.databinding.ActivityCronometroBinding

class ChronometerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCronometroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCronometroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupChronometer()

    }
    private fun setupChronometer() {
        binding.chronometer.apply {
            base = SystemClock.elapsedRealtime()
        }
    }

    fun startTimer(view: View) {
        setupChronometer()
        binding.chronometer.start()
    }


    fun stopTimer(view: View) {
        binding.chronometer.stop()
        Toast.makeText(this,"Timer stopped!",Toast.LENGTH_SHORT).show()
        setupChronometer()
    }



}