package com.practicum.wgtest

import android.content.Intent
import android.net.VpnService
import android.net.VpnService.Builder
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var tvMain: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMain = findViewById(R.id.tvMain)
        tvMain.setOnClickListener {

            val startVpn = VpnService.prepare(this)
            if (startVpn != null) {
                startActivity(startVpn)
                var newStartVpn = startVpn

            } else {
                onActivityResult(0, RESULT_OK, null)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            var intent =  Intent(this, MyVpnService::class.java)
            startService(intent)
        }
    }
}