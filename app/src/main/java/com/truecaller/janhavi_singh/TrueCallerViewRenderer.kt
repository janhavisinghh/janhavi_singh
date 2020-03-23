package com.truecaller.janhavi_singh

@Suppress("NAME_SHADOWING")
class TrueCallerViewRenderer(private val trueCallerView: TrueCallerView) {
    private var tenthCharRequestResponse: Char? = null
    private var everyTenthCharResponse: String? = null
    private var wordCounterRequestResponse: String? = null
    private var trueCallerResponse: String = ""


    fun render(model: TrueCallerModel) {
        if (model.networkCallStatus == NetworkCallStatus.SUCCESSFUL) {
            trueCallerResponse = model.trueCallerUrlResponse!!
            tenthCharRequestResponse = tenthCharRequest(trueCallerResponse[10])
            everyTenthCharResponse = everyTenthCharRequest(trueCallerResponse)
            wordCounterRequestResponse = wordCounterRequest(trueCallerResponse)

            tenthCharRequestResponse?.let { it -> trueCallerView.displayTenthCharRequest(it) }
            everyTenthCharResponse?.let { it -> trueCallerView.displayEveryTenthCharRequest(it) }
            wordCounterRequestResponse?.let { it -> trueCallerView.displayWordCounterRequest(it) }

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

    private fun wordCounterRequest(responseString: String): String? {
        val delimiters = Regex("\\s+|,\\s*|\\.\\s*")
        val words: List<String> = responseString.split(delimiters)
        val uniqueWords: ArrayList<String> = ArrayList()
        val uniqueWordsCounter: ArrayList<Int> = ArrayList()
        var resultString: String? = null

        for (word in words) {
            val wordIsRepeated = checkIfWordIsUnique(word, uniqueWords)
            if (wordIsRepeated == -1) {
                uniqueWords.add(word)
                uniqueWordsCounter.add(1)
            } else {
                uniqueWordsCounter[wordIsRepeated] += 1
            }
        }

        for (i in 0 until uniqueWords.size) {
            resultString += "${uniqueWords[i]} -> occurred ${uniqueWordsCounter[i]} times\n"
        }
        return resultString
    }

    private fun checkIfWordIsUnique(word: String, uniqueWords: ArrayList<String>): Int {
        for (i in 0 until uniqueWords.size) {
            if (word == uniqueWords[i])
                return i
        }
        return -1
    }
}