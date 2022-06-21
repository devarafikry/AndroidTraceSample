package com.example.tracesampleactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Trace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val name = object{}.javaClass.enclosingMethod?.name
        val traceName = "$localClassName#$name"

        Trace.beginSection(traceName)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        someLightFunction()
        someHeavyFunction()

        Thread.sleep(700)
        someAnotherFunctionAfterDelay()

        Trace.endSection()
    }

    private fun someHeavyFunction() {
        val name = object{}.javaClass.enclosingMethod?.name
        val traceName = "$localClassName#$name"

        Trace.beginSection(traceName)
        Thread.sleep(5000)
        Trace.endSection()
    }

    private fun someLightFunction() {
        val name = object{}.javaClass.enclosingMethod?.name
        val traceName = "$localClassName#$name"

        Trace.beginSection(traceName)
        Thread.sleep(500)
        Trace.endSection()
    }

    private fun someAnotherFunctionAfterDelay() {
        val name = object{}.javaClass.enclosingMethod?.name
        val traceName = "$localClassName#$name"

        Trace.beginSection(traceName)
        Thread.sleep(1000)
        Trace.endSection()
    }
}