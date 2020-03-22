package com.truecaller.janhavi_singh

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.spotify.mobius.Connectable
import com.spotify.mobius.Connection
import com.spotify.mobius.Mobius
import com.spotify.mobius.android.MobiusAndroid
import com.spotify.mobius.functions.Consumer
import com.truecaller.janhavi_singh.databinding.ActivityTruecallerBinding

class TrueCallerActivity : AppCompatActivity(), TrueCallerView, TrueCallerViewActions,
    Connectable<TrueCallerModel, TrueCallerEvent> {
    companion object {
        private const val KEY_MODEL = "key_model"
    }

    var binding: ActivityTruecallerBinding? = null
    private val loop = Mobius.loop(
        TrueCallerUpdate(),
        TrueCallerEffectHandler(this)
    )
    private val controller = MobiusAndroid.controller(loop, TrueCallerModel.INIT)
    private val viewRenderer: TrueCallerViewRenderer by lazy {
        TrueCallerViewRenderer(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_truecaller)

        if (savedInstanceState != null) {
            val model = savedInstanceState.getParcelable(KEY_MODEL) ?: TrueCallerModel.INIT
            controller.replaceModel(model)
        }

        controller.connect(this)
    }

    override fun onResume() {
        super.onResume()
        controller.start()
    }

    override fun onPause() {
        super.onPause()
        controller.stop()
    }

    override fun onDestroy() {
        controller.disconnect()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putParcelable(KEY_MODEL, controller.model)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun connect(output: Consumer<TrueCallerEvent>): Connection<TrueCallerModel> {
        binding!!.hitUrlButton.setOnClickListener {
            output.accept(
                TrueCallerUrlButtonClicked
            )
        }
        return object : Connection<TrueCallerModel> {
            override fun accept(value: TrueCallerModel) {
                viewRenderer.render(value)
            }

            override fun dispose() {
            }
        }
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
