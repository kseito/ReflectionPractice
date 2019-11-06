package com.example.reflectionpractice

import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User(1, "kseito", "I love Splatoon!")
        val cls = User::class
        cls.memberProperties.forEach {
            it.isAccessible = true
            println("${it.name} value is ${it.get(user)}")
        }


        val textView = TextView(this)
        val cls2 = TextView::class
        cls2.memberProperties.filter { it.name == "mMaximum" }.forEach {
            it.isAccessible = true
            println("${it.name} value is ${it.get(textView)}")
        }
    }
}
