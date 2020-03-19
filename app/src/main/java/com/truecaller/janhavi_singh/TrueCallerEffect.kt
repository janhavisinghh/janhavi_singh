package com.truecaller.janhavi_singh

sealed class TrueCallerEffect

object HitTrueCallerUrl : TrueCallerEffect()

object ShowHitUrlFailedErrorMessage : TrueCallerEffect()

data class ShowSuccessfulResponseData(val trueCallerUrlResponse: String) : TrueCallerEffect()