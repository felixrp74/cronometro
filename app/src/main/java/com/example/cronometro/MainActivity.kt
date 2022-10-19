package com.example.cronometro

import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButton.setOnClickListener {
            play()
        }

    }

    private fun play(){
        val seg = binding.txtSegundos.text.toString().toLong()*1000
        val min = binding.txtMinutos.text.toString().toLong()*1000*60
        val hor = binding.txtHoras.text.toString().toLong()*1000*60*60
        val tiempoMilisegundos = seg+min+hor

        object : CountDownTimer(tiempoMilisegundos, 1000){
            override fun onFinish() {
                val notificacion = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
                val r = RingtoneManager.getRingtone(this@MainActivity, notificacion)
                r.play()
                this.cancel()
            }

            override fun onTick(millisUntilFinished: Long) {
                var tiempoSegundos = (millisUntilFinished/1000).toInt()+1
                val horas = tiempoSegundos/3600
                tiempoSegundos %= 3600

                val min = tiempoSegundos/60
                tiempoSegundos = tiempoSegundos%60
                binding.tvTimeBack.text = horas.toString().padStart(2,'0')+":"+min.toString().padStart(2,'0')+":"+tiempoSegundos.toString().padStart(2,'0')


            }

        }.start()

    }

}