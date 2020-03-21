package com.truecaller.janhavi_singh

@Suppress("NAME_SHADOWING")
class TrueCallerViewRenderer(private val trueCallerView: TrueCallerView) {
    private var tenthCharRequestResponse: String? = null
    private var everyTenthCharResponse: String? = null
    private var wordCounterRequestResponse: String? = null
    private val dummyStringForTest: String = "This is for testing"

    fun render(model: TrueCallerModel) {
        model.trueCallerUrlResponse?.let {
            tenthCharRequestResponse = tenthCharRequest()
            everyTenthCharResponse = everyTenthCharRequest()
            wordCounterRequestResponse = wordCounterRequest()

            tenthCharRequestResponse?.let { it -> trueCallerView.displayTenthCharRequest(it) }
            everyTenthCharResponse?.let { it -> trueCallerView.displayEveryTenthCharRequest(it) }
            wordCounterRequestResponse?.let { it -> trueCallerView.displayWordCounterRequest(it) }
        }
    }

    private fun tenthCharRequest(): String? {
        return dummyStringForTest
    }

    private fun everyTenthCharRequest(): String? {
        return dummyStringForTest
    }

    private fun wordCounterRequest(): String? {
        return dummyStringForTest
    }
}