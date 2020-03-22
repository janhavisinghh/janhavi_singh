package com.truecaller.janhavi_singh

@Suppress("NAME_SHADOWING")
class TrueCallerViewRenderer(private val trueCallerView: TrueCallerView) {
    private var tenthCharRequestResponse: Char? = null
    private var everyTenthCharResponse: String? = null
    private var wordCounterRequestResponse: String? = null
    private val dummyStringForTest: String = "This is for testing"

    fun render(model: TrueCallerModel) {
        if (model.networkCallStatus == NetworkCallStatus.SUCCESSFUL) {
            model.trueCallerUrlResponse?.let {
                tenthCharRequestResponse = tenthCharRequest(it[10])
                everyTenthCharResponse = everyTenthCharRequest(it)
                wordCounterRequestResponse = wordCounterRequest()

                tenthCharRequestResponse?.let { it -> trueCallerView.displayTenthCharRequest(it) }
                everyTenthCharResponse?.let { it -> trueCallerView.displayEveryTenthCharRequest(it) }
                wordCounterRequestResponse?.let { it -> trueCallerView.displayWordCounterRequest(it) }
            }
        }
    }

    private fun tenthCharRequest(tenthChar: Char): Char? {
        return tenthChar
    }

    private fun everyTenthCharRequest(responseString: String): String? {
        var everyTenthChar = " "
        var n = 10
        while (n < responseString.length) {
            everyTenthChar = "$everyTenthChar " + responseString[n]
            n += 10
        }
        return everyTenthChar
    }

    private fun wordCounterRequest(): String? {
        return dummyStringForTest
    }
}