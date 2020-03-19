package com.truecaller.janhavi_singh

sealed class TrueCallerEvent

object TrueCallerUrlButtonClicked : TrueCallerEvent()

object HitUrlFailed : TrueCallerEvent()

data class HitUrlSuccessful(val trueCallerUrlResponse: String) : TrueCallerEvent()