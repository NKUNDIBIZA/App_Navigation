package com.cyogere.nav_ctrl_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var btn0:Button? = null
    var btn1:Button? = null
    var btn2:Button? = null
    var btn3:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0 = findViewById(R.id.name_button0)
        btn1 = findViewById(R.id.name_button1)
        btn2 = findViewById(R.id.name_button2)
    }

    private fun clickHandler() {
        TODO("Not yet implemented")
    }
}
