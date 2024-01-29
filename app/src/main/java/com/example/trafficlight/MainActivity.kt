package com.example.trafficlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {
    var imSemafor: ImageView? = null
    var counter:Int = 0
    var timer: Timer? = null
    var is_run = false
    var imageArray:IntArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imSemafor = findViewById(R.id.imSemafor)
        imSemafor?.setImageResource(R.drawable.semafor_grey)
    }
    fun onClickStarStop(view: View) {
        view as ImageButton
        if (!is_run) {

            startStop()


            view.setImageResource(R.drawable.button_stop)
            is_run = true
        }

        else
        {
            imSemafor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            is_run = false
            counter = 0

        }
    fun startStop() {
            timer = Timer()
            timer?.schedule(object : TimerTask(){
                override fun run() {
                    runOnUiThread{
                        imSemafor?.setImageResource(imageArray[counter])
                        counter++
                        if(counter == 3)counter = 0
                    }
                }

            },0,1000)
    }
    }

     fun startStop() {
        timer = Timer()
        timer?.schedule(object : TimerTask(){
            override fun run() {
                runOnUiThread{
                    imSemafor?.setImageResource(imageArray[counter])
                    counter++
                    if(counter == 3)counter = 0
                }
            }

        },0,1000)
    }


}