package com.jean.demo.intenttest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThirdActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        title = "ThirdActivity"

        findViewById<Button>(R.id.btn_last).setOnClickListener({
            val intent = Intent(ThirdActivity@this, SecondActivity::class.java)
            intent.putExtra("key", "last")
            startActivity(intent)
        })
        findViewById<Button>(R.id.btn_next).setOnClickListener({
            val intent = Intent(ThirdActivity@this, ThirdActivity::class.java)
            intent.putExtra("key", "next")
            startActivity(intent)
        })
        findViewById<Button>(R.id.btn_return).setOnClickListener({
            finish()
        })
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        var extra = intent?.getStringExtra("key")
        if (extra == null) {
            extra = "empty"
        }
        Log.e("ThirdActivity", "onNewIntent $extra")

        setIntent(intent)
    }

    override fun onResume() {
        super.onResume()

        var extra = intent.getStringExtra("key")
        if (extra == null) {
            extra = "empty"
        }
        Log.e("ThirdActivity", "onResume $extra")
    }
}
