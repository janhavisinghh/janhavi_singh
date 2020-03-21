package com.truecaller.janhavi_singh

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.truecaller.janhavi_singh.databinding.ActivityTruecallerBinding

class TrueCallerActivity : AppCompatActivity() {
    var binding: ActivityTruecallerBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_truecaller)
    }
}
