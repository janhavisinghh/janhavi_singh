package com.truecaller.janhavi_singh

import com.spotify.mobius.Next
import com.spotify.mobius.Next.dispatch
import com.spotify.mobius.Update

class TrueCallerUpdate : Update<TrueCallerModel, TrueCallerEvent, TrueCallerEffect> {
    override fun update(model: TrueCallerModel, event: TrueCallerEvent): Next<TrueCallerModel, TrueCallerEffect> {
        return when (event) {
            TrueCallerUrlButtonClicked -> dispatch(setOf(HitTrueCallerUrl as TrueCallerEffect))
        }
    }
}
