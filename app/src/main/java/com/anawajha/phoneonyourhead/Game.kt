package com.anawajha.phoneonyourhead

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.anawajha.phoneonyourhead.shared.categories
import com.anawajha.phoneonyourhead.shared.jobs
import java.lang.reflect.Array.get
import java.nio.file.Files.list
import kotlin.concurrent.thread

class Game : AppCompatActivity(), SensorEventListener {
    lateinit var layout: LinearLayout
    lateinit var sm: SensorManager
    var accelerometor: Sensor? = null
    var gyroscope: Sensor? = null
    var words :ArrayList<String> = jobs //categories[intent.getIntExtra("index",0)].words
    lateinit var showQ: Thread
    lateinit var t_timer: TextView
    lateinit var t_score: TextView
    lateinit var t_word: TextView
    lateinit var evaluation: TextView
    private var score = 0
    private var isTrue: Boolean = false
    private var isFalse: Boolean = false
    private var index = 0
    var y :Float = 0.0f
    var z :Float= 0.0f
    lateinit var mediaPlayer: MediaPlayer
    var thead = false



    val countDownTimer = object : CountDownTimer(60000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val a = millisUntilFinished / 1000
            if (a == 15L) {
                tick_mp()
                mediaPlayer.start()
                mediaPlayer.isLooping = true
                t_timer.setTextColor(Color.parseColor("#C70039"))
            }
            runOnUiThread {
                t_timer.text = "0.${a}"
            }
        }

        override fun onFinish() {
                mediaPlayer.stop()

            t_timer.text = "0.0"
            runOnUiThread {
                t_word.text = "إنتهى الوقت"
                t_word.setTextColor(Color.parseColor("#C70039"))
            }
            index = words.size
            finish.start()

        }
    }

    val t = getTimer(1000,500,{
        layout.setBackgroundColor(Color.parseColor("#EEEEEE"))
        evaluation.text = ""
    },null)


    val finish = getTimer(2000,1000,{
        val i = Intent(this,Result::class.java)
        i.putExtra("score",score)
        i.putStringArrayListExtra("a",words)
        startActivity(i)
        finish()
    },null)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
//        words = categories[intent.getIntExtra("index",0)].words

        words= intent.getStringArrayListExtra("a") as ArrayList<String>



        sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        t_word = findViewById(R.id.tv_word)
        t_timer = findViewById(R.id.tv_timer)
        t_score = findViewById(R.id.tv_score)
        layout = findViewById(R.id.lo_background)
        evaluation = findViewById(R.id.tv_result)
        t_score.text = score.toString()


        showQ = Thread {
            while (index <= words.size - 1) {

                runOnUiThread {
                    t_word.text = words[index]
                    t_score.text = score.toString()
                }

                Thread.sleep(2000)


                if (isTrue) {
                    isTure()
                    true_mp()
                    layout.setBackgroundColor(Color.parseColor("#22267B"))
                    evaluation.text = "أحسنت"
                    t.start()
                }

                if (isFalse) {
                    isFalse()
                    wrong_mp()
                    layout.setBackgroundColor(Color.parseColor("#C70039"))
                    evaluation.text = "إجابة خاطئة"
                    t.start()
                }

                if (index == words.size - 1) {
                    runOnUiThread {
                        evaluation.text = "إنتهت الأسئلة"
                        evaluation.setTextColor(Color.parseColor("#C70039"))
                        countDownTimer.cancel()
                        finish.start()
                       thead= true
                    }

                }
            }
        }

        if (thead){
            showQ.destroy()
            thead = false
        }

    }

    override fun onStart() {
        super.onStart()
        showQ.start()
        countDownTimer.start()
    }


    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_GYROSCOPE) {
             y = event.values[1]
        }

        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER){
             z = event.values[2]
        }

        if ((y < -3) && (z < - 3)) {
            isTrue = true
        } else if ((y > 3) && (z > 3)) {
            isFalse = true
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onResume() {
        super.onResume()

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        accelerometor?.let {
            sm.registerListener(this, accelerometor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        gyroscope?.let {
            Log.d("AAA", "accelerometer")
            sm.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
            Log.d("gyroscope","Exist")
        }
    }

    override fun onPause() {
        super.onPause()
        showQ.interrupt()
        countDownTimer.cancel()
        accelerometor?.let {
            sm.unregisterListener(this)
        }
        gyroscope?.let {
            sm.unregisterListener(this)
        }
    }


    fun isTure() {
        score++
        index++
        isTrue = false
        isFalse = false
    }

    fun isFalse() {
        index++
        isFalse = false
        isTrue = false
    }

    fun tick_mp(){
        mediaPlayer = MediaPlayer.create(this, R.raw.clock_tick)
        mediaPlayer.start()
    }

    fun true_mp(){
        mediaPlayer = MediaPlayer.create(this, R.raw.excellent)
        mediaPlayer.start()
    }

    fun wrong_mp(){
        mediaPlayer = MediaPlayer.create(this, R.raw.wrong)
        mediaPlayer.start()
    }

    fun getTimer(time:Long,interval:Long,finish:() -> Unit ,tick:(() -> Unit)?):CountDownTimer{
        val t = object : CountDownTimer(time, interval) {
            override fun onTick(millisUntilFinished: Long) {
                tick?.let {
                    tick()
                }
            }

            override fun onFinish() {
              finish()
            }
        }
        return t
    }

    fun end(){
        val i = Intent(this,Result::class.java)
        i.putExtra("score",score)
        i.putStringArrayListExtra("a",words)
        startActivity(i)
        finish()
    }





}