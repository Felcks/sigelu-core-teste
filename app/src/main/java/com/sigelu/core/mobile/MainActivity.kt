package com.sigelu.core.mobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sigelu.core.lib.checarGpsAtivo
import com.sigelu.core.lib.isGpsAtivo
import com.sigelu.core.mobile.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activity = this

        btn_hello.setOnClickListener{
            Logger().error(isGpsAtivo(activity).toString())
        }
    }
}
