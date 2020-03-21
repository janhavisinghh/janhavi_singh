package com.truecaller.janhavi_singh

import com.truecaller.janhavi_singh.NetworkCallStatus.FAILED
import com.truecaller.janhavi_singh.NetworkCallStatus.SUCCESSFUL

data class TrueCallerModel(val networkCallStatus: NetworkCallStatus?, val trueCallerUrlResponse: String?) {
    companion object {
        val INIT = TrueCallerModel(null, null)
    }

    fun hitUrlFailed(): TrueCallerModel {
        return copy(networkCallStatus = FAILED)
    }

    fun hitUrlSuccessful(trueCallerUrlResponse: String?): TrueCallerModel {
        return copy(networkCallStatus = SUCCESSFUL, trueCallerUrlResponse = trueCallerUrlResponse)
    }
}
