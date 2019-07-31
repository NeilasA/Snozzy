package com.example.snozzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.widget.Button
import android.widget.ToggleButton
import androidx.core.os.postDelayed
import java.io.IOException



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsButton = findViewById<View>(R.id.settingsButton) as Button

            settingsButton.setOnClickListener {
                var intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }

        val alarmSong = R.raw.amv
        val toggleButton = findViewById<View>(R.id.startToggleButton) as ToggleButton
            val mp = MediaPlayer.create(this, alarmSong)
                 mp.stop()
            val alarmTime = 5000L

            toggleButton.setOnClickListener {
                if (mp.isPlaying) {
                    mp.stop()
                } else if (!mp.isPlaying) {
                    try {
                        Handler().postDelayed( alarmTime ){
                        mp.prepare()
                        mp.start()
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

        }

    }
