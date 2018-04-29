package com.jean.demo.intenttest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "MainActivity"

        findViewById<Button>(R.id.btn_last).setOnClickListener({
            val intent = Intent(MainActivity@this, MainActivity::class.java)
            intent.putExtra("key", "last")
            startActivity(intent)
        })
        findViewById<Button>(R.id.btn_next).setOnClickListener({
            val intent = Intent(MainActivity@this, SecondActivity::class.java)
            intent.putExtra("key", "next")
            startActivity(intent)
        })
        findViewById<Button>(R.id.btn_return).setOnClickListener({
            val intent = Intent(MainActivity@this, MainActivity::class.java)
            intent.putExtra("key", "return")
            startActivity(intent)
        })
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        var extra = intent?.getStringExtra("key")
        if (extra == null) {
            extra = "empty"
        }
        Log.e("MainActivity", "onNewIntent $extra")

        setIntent(intent)
    }

    override fun onResume() {
        super.onResume()

        var extra = intent.getStringExtra("key")
        if (extra == null) {
            extra = "empty"
        }
        Log.e("MainActivity", "onResume $extra")
    }
}
