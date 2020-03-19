package com.truecaller.janhavi_singh

data class TrueCallerModel(val networkCallStatus: NetworkCallStatus?) {
    companion object {
        val INIT = TrueCallerModel(null)
    }
}
