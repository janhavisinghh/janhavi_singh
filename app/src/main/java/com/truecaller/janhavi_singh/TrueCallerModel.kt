package com.truecaller.janhavi_singh

import com.truecaller.janhavi_singh.NetworkCallStatus.FAILED

data class TrueCallerModel(val networkCallStatus: NetworkCallStatus?) {
    companion object {
        val INIT = TrueCallerModel(null)
    }

    fun hitUrlFailed(): TrueCallerModel {
        return copy(networkCallStatus = FAILED)
    }
}
