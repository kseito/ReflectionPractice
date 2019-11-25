package com.example.reflectionpractice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User(1, "kseito", "I love Splatoon!")
        val cls = User::class

        //private method reference
        cls.memberFunctions
            .filter { it.name == "getFullInfo" }
            .forEach {
                it.isAccessible = true
                println("This function name is ${it.name}. value is ${it.call(user)}")
            }

        //private property reference
        cls.memberProperties
            .filter { it.name == "description" }
            .forEach {
                it.isAccessible = true
                println("${it.name} value is ${it.get(user)}")
            }


        val textView = findViewById<TextView>(R.id.text_view)
        val cls2 = TextView::class
        cls2.memberProperties
            .filter { it.name == "mText" }
            .forEach {
                it.isAccessible = true
                println("${it.name} value is ${it.get(textView)}")
            }
    }
}
