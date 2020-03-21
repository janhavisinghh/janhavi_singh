package com.truecaller.janhavi_singh

sealed class TrueCallerEffect

object HitTrueCallerUrl : TrueCallerEffect()

object ShowHitUrlFailedErrorMessage : TrueCallerEffect()