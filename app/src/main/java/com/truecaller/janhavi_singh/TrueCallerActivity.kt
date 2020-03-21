package com.truecaller.janhavi_singh

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.truecaller.janhavi_singh.databinding.ActivityTruecallerBinding

class TrueCallerActivity : AppCompatActivity(), TrueCallerView, TrueCallerViewActions {

    var binding: ActivityTruecallerBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_truecaller)
    }

    override fun displayTenthCharRequest(tenthCharResponse: String) {
        binding!!.tenthCharTextView.text = tenthCharResponse
    }

    override fun displayEveryTenthCharRequest(everyTenthCharResponse: String) {
        binding!!.everyTenthCharTextView.text = everyTenthCharResponse
    }

    override fun displayWordCounterRequest(wordCounterResponse: String) {
        binding!!.wordCounterTextView.text = wordCounterResponse
    }


    override fun showHitUrlFailedErrorMessage() {
        Toast.makeText(this, "There was some error! Try Again!", Toast.LENGTH_SHORT).show()
    }
}
